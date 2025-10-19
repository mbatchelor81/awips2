variable "aws_region" {
  description = "AWS region for AWIPS2 EDEX deployment"
  type        = string
  default     = "us-east-1"
}

variable "environment" {
  description = "Environment name (e.g., dev, staging, prod)"
  type        = string
  default     = "dev"
}

variable "project_name" {
  description = "Project name for resource tagging"
  type        = string
  default     = "awips2-edex"
}

variable "vpc_cidr" {
  description = "CIDR block for VPC"
  type        = string
  default     = "10.0.0.0/16"
}

variable "availability_zones" {
  description = "List of availability zones to use"
  type        = list(string)
  default     = []
}

variable "public_subnet_cidrs" {
  description = "CIDR blocks for public subnets"
  type        = list(string)
  default     = ["10.0.1.0/24", "10.0.2.0/24"]
}

variable "private_subnet_cidrs" {
  description = "CIDR blocks for private subnets"
  type        = list(string)
  default     = ["10.0.10.0/22", "10.0.14.0/22"]
}

variable "edex_http_port" {
  description = "Port for EDEX HTTP services"
  type        = number
  default     = 9581
}

variable "postgres_port" {
  description = "Port for PostgreSQL database"
  type        = number
  default     = 5432
}

variable "messaging_port" {
  description = "Port for messaging service (Apache Qpid)"
  type        = number
  default     = 5672
}

variable "health_check_path" {
  description = "Health check path for EDEX services"
  type        = string
  default     = "/services"
}

variable "enable_nat_gateway" {
  description = "Enable NAT Gateway for private subnets"
  type        = bool
  default     = true
}

variable "single_nat_gateway" {
  description = "Use a single NAT Gateway for all private subnets (cost optimization)"
  type        = bool
  default     = false
}

variable "tags" {
  description = "Additional tags to apply to all resources"
  type        = map(string)
  default     = {}
}
