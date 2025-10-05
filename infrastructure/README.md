# AWIPS2 EDEX AWS Infrastructure

This directory contains Terraform Infrastructure as Code (IaC) for deploying the AWIPS2 Environmental Data EXchange (EDEX) system on AWS. The infrastructure implements a cloud-native, container-ready architecture supporting both Amazon ECS and Amazon EKS deployment models.

## Overview

The infrastructure creates foundational AWS networking components for the AWIPS2 EDEX deployment, focusing on the three core service ports:

- **Port 9581**: EDEX HTTP services endpoint
- **Port 5432**: PostgreSQL database access
- **Port 5672**: Messaging service (Apache Qpid)

## Architecture

### Network Design

The infrastructure uses a multi-tier VPC architecture with clear separation between public and private resources:

```
┌─────────────────────────────────────────────────────────────┐
│                         VPC (10.0.0.0/16)                   │
│                                                             │
│  ┌────────────────────────────────────────────────────┐   │
│  │              Public Subnets (2 AZs)                │   │
│  │  ┌──────────────────┐    ┌──────────────────┐     │   │
│  │  │  10.0.1.0/24     │    │  10.0.2.0/24     │     │   │
│  │  │                  │    │                  │     │   │
│  │  │  ┌────┐ ┌────┐  │    │  ┌────┐ ┌────┐  │     │   │
│  │  │  │ALB │ │NAT │  │    │  │ALB │ │NAT │  │     │   │
│  │  │  └────┘ └────┘  │    │  └────┘ └────┘  │     │   │
│  │  └──────────────────┘    └──────────────────┘     │   │
│  └────────────────────────────────────────────────────┘   │
│                                                             │
│  ┌────────────────────────────────────────────────────┐   │
│  │             Private Subnets (2 AZs)                │   │
│  │  ┌──────────────────┐    ┌──────────────────┐     │   │
│  │  │  10.0.10.0/22    │    │  10.0.14.0/22    │     │   │
│  │  │                  │    │                  │     │   │
│  │  │  ┌────────────┐  │    │  ┌────────────┐  │     │   │
│  │  │  │ ECS/EKS    │  │    │  │ ECS/EKS    │  │     │   │
│  │  │  │ Containers │  │    │  │ Containers │  │     │   │
│  │  │  └────────────┘  │    │  └────────────┘  │     │   │
│  │  └──────────────────┘    └──────────────────┘     │   │
│  └────────────────────────────────────────────────────┘   │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Components

#### VPC and Networking (`vpc.tf`)

- **VPC**: 10.0.0.0/16 CIDR block with DNS hostnames and resolution enabled
- **Public Subnets**: Two /24 subnets (10.0.1.0/24, 10.0.2.0/24) across availability zones
  - Used for Application Load Balancer and NAT Gateways
  - Direct internet access via Internet Gateway
- **Private Subnets**: Two /22 subnets (10.0.10.0/22, 10.0.14.0/22) across availability zones
  - Used for container workloads (ECS tasks or EKS pods)
  - Outbound internet access via NAT Gateways
- **Internet Gateway**: Provides internet connectivity for public subnets
- **NAT Gateways**: One per availability zone for private subnet outbound traffic

#### Security Groups (`security-groups.tf`)

Three security groups implementing defense-in-depth security:

1. **ALB Security Group**
   - Inbound: HTTP (80) and HTTPS (443) from internet (0.0.0.0/0)
   - Outbound: Port 9581 to application security group

2. **Application Security Group**
   - Inbound from ALB: Port 9581 (EDEX HTTP services)
   - Inbound internal: Port 5432 (PostgreSQL) - self-referencing
   - Inbound internal: Port 5672 (Apache Qpid messaging) - self-referencing
   - Outbound: All traffic for external dependencies

3. **Database Security Group**
   - Inbound: Port 5432 from application security group only
   - No egress rules (database tier isolation)

#### Application Load Balancer (`load-balancer.tf`)

- **ALB**: Internet-facing load balancer in public subnets
- **Target Group**: Configured for port 9581 with IP target type
- **Health Check**: 
  - Path: `/services` (EDEX HTTP services endpoint)
  - Healthy threshold: 2 consecutive successes
  - Unhealthy threshold: 5 consecutive failures
  - Timeout: 5 seconds
  - Interval: 30 seconds
- **Listeners**: 
  - HTTP listener on port 80
  - HTTPS listener on port 443 (requires SSL certificate ARN)

#### IAM Roles (`iam.tf`)

Implements least-privilege IAM roles for container orchestration:

1. **ECS Task Execution Role**
   - Allows ECS to pull container images from ECR
   - Manages CloudWatch Logs integration
   - Attached policies:
     - `AmazonECSTaskExecutionRolePolicy`
     - `AmazonEC2ContainerRegistryReadOnly`

2. **ECS Task Role**
   - Application-level permissions for EDEX containers
   - Access to CloudWatch Logs, Secrets Manager, SSM Parameter Store
   - Custom policy for AWIPS2-specific resources

3. **EKS Cluster Role**
   - Manages EKS cluster operations
   - Attached policies:
     - `AmazonEKSClusterPolicy`
     - `AmazonEKSVPCResourceController`

4. **EKS Node Group Role**
   - Permissions for EKS worker nodes
   - Attached policies:
     - `AmazonEKSWorkerNodePolicy`
     - `AmazonEKS_CNI_Policy`
     - `AmazonEC2ContainerRegistryReadOnly`

## Prerequisites

### Required Tools

- [Terraform](https://www.terraform.io/downloads.html) >= 1.0
- [AWS CLI](https://aws.amazon.com/cli/) >= 2.0
- AWS account with appropriate permissions

### AWS Account Setup

The infrastructure requires an AWS account with the following:

1. **S3 Backend**: Create an S3 bucket for Terraform state storage
   - Update `backend "s3"` configuration in `provider.tf`
   - Replace `PLACEHOLDER-terraform-state-bucket` with your bucket name

2. **DynamoDB Table**: Create a DynamoDB table for state locking
   - Update `dynamodb_table` in `provider.tf`
   - Replace `PLACEHOLDER-terraform-locks` with your table name

3. **SSL Certificate** (for HTTPS):
   - Request or import an SSL certificate in AWS Certificate Manager
   - Update `certificate_arn` in `load-balancer.tf`
   - Replace `arn:aws:acm:REGION:ACCOUNT_ID:certificate/CERTIFICATE_ID`

4. **IAM Permissions**: Ensure your AWS credentials have permissions to create:
   - VPC and networking resources
   - Security groups
   - Application Load Balancers
   - IAM roles and policies
   - (Optional) ECS clusters and services
   - (Optional) EKS clusters and node groups

## Configuration

### Variables

All configurable parameters are defined in `variables.tf`. Key variables include:

| Variable | Description | Default |
|----------|-------------|---------|
| `aws_region` | AWS region for deployment | `us-east-1` |
| `environment` | Environment name (dev/staging/prod) | `dev` |
| `project_name` | Project name for resource tagging | `awips2-edex` |
| `vpc_cidr` | VPC CIDR block | `10.0.0.0/16` |
| `public_subnet_cidrs` | Public subnet CIDR blocks | `["10.0.1.0/24", "10.0.2.0/24"]` |
| `private_subnet_cidrs` | Private subnet CIDR blocks | `["10.0.10.0/22", "10.0.14.0/22"]` |
| `edex_http_port` | EDEX HTTP services port | `9581` |
| `postgres_port` | PostgreSQL database port | `5432` |
| `messaging_port` | Messaging service port | `5672` |
| `health_check_path` | ALB health check path | `/services` |

### Customization

Create a `terraform.tfvars` file to override defaults:

```hcl
aws_region   = "us-west-2"
environment  = "production"
project_name = "awips2-edex"

vpc_cidr              = "10.0.0.0/16"
public_subnet_cidrs   = ["10.0.1.0/24", "10.0.2.0/24"]
private_subnet_cidrs  = ["10.0.10.0/22", "10.0.14.0/22"]

single_nat_gateway = false

tags = {
  Department = "Meteorology"
  CostCenter = "Research"
  Jira       = "DD-4"
}
```

## Deployment

### Initial Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mbatchelor81/awips2.git
   cd awips2/infrastructure
   ```

2. **Configure AWS credentials**:
   ```bash
   aws configure
   ```
   Or set environment variables:
   ```bash
   export AWS_ACCESS_KEY_ID="your-access-key"
   export AWS_SECRET_ACCESS_KEY="your-secret-key"
   export AWS_DEFAULT_REGION="us-east-1"
   ```

3. **Update placeholders** in `provider.tf`:
   - S3 backend bucket name
   - DynamoDB table name
   - Update `certificate_arn` in `load-balancer.tf`

4. **Initialize Terraform**:
   ```bash
   terraform init
   ```

### Deployment Steps

1. **Review the execution plan**:
   ```bash
   terraform plan
   ```

2. **Apply the infrastructure**:
   ```bash
   terraform apply
   ```
   Review the plan and type `yes` to confirm.

3. **Save outputs**:
   ```bash
   terraform output > outputs.txt
   ```

### Post-Deployment

After successful deployment, you'll have:

- VPC with public and private subnets across 2 availability zones
- Internet Gateway and NAT Gateways for connectivity
- Security groups configured for ALB, application, and database tiers
- Application Load Balancer ready to route traffic to EDEX services
- IAM roles prepared for ECS and EKS deployments

## Outputs

The infrastructure exports the following outputs for use by application deployment:

- **Networking**: VPC ID, subnet IDs, availability zones
- **Security**: Security group IDs for ALB, application, and database
- **Load Balancing**: ALB DNS name, ARN, target group ARN
- **IAM**: Role ARNs for ECS tasks and EKS clusters

View all outputs:
```bash
terraform output
```

View specific output:
```bash
terraform output alb_dns_name
```

## Next Steps

### For ECS Deployment

1. Create an ECS cluster in the VPC
2. Define ECS task definitions for EDEX services
3. Configure ECS services to use:
   - Private subnets for task placement
   - Application security group
   - ALB target group for port 9581

### For EKS Deployment

1. Create an EKS cluster using the cluster IAM role
2. Create node groups in private subnets with node IAM role
3. Deploy EDEX as Kubernetes deployments/services
4. Configure Ingress to use the ALB

### Database Setup

For PostgreSQL:
- Deploy RDS PostgreSQL instance in private subnets
- Use database security group
- Configure connection strings in application

For containerized PostgreSQL:
- Deploy as ECS task or Kubernetes StatefulSet
- Use private subnets and database security group

## Maintenance

### Updating Infrastructure

1. Modify the desired `.tf` files
2. Run `terraform plan` to preview changes
3. Run `terraform apply` to apply changes

### Scaling

To add more availability zones:
```hcl
availability_zones     = ["us-east-1a", "us-east-1b", "us-east-1c"]
public_subnet_cidrs    = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
private_subnet_cidrs   = ["10.0.10.0/22", "10.0.14.0/22", "10.0.18.0/22"]
```

### Cost Optimization

To use a single NAT Gateway (reduces costs):
```hcl
single_nat_gateway = true
```

## Cleanup

To destroy all infrastructure:

```bash
terraform destroy
```

**Warning**: This will permanently delete all resources. Ensure you have backups of any data.

## Security Considerations

- All application workloads run in private subnets with no direct internet access
- Database access is restricted to application security group only
- Security groups follow least-privilege principle
- NAT Gateways provide controlled outbound internet access
- IAM roles use minimum required permissions

## Troubleshooting

### Common Issues

1. **Terraform state lock**: If state is locked, identify and remove the lock in DynamoDB
2. **Insufficient permissions**: Ensure AWS credentials have required IAM permissions
3. **Resource limits**: Check AWS service quotas for your account
4. **Certificate errors**: Verify SSL certificate ARN is correct and in the right region

## References

- [Jira Ticket DD-4](https://your-jira-instance/browse/DD-4)
- [AWIPS2 Documentation](https://github.com/mbatchelor81/awips2)
- [Terraform AWS Provider Documentation](https://registry.terraform.io/providers/hashicorp/aws/latest/docs)

## Support

For issues or questions:
- Repository: https://github.com/mbatchelor81/awips2
- Jira: DD-4
- Maintainer: @mbatchelor81
