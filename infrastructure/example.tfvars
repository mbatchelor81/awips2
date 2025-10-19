aws_region   = "us-east-1"
environment  = "dev"
project_name = "awips2-edex"

vpc_cidr              = "10.0.0.0/16"
public_subnet_cidrs   = ["10.0.1.0/24", "10.0.2.0/24"]
private_subnet_cidrs  = ["10.0.10.0/22", "10.0.14.0/22"]

edex_http_port = 9581
postgres_port  = 5432
messaging_port = 5672

health_check_path = "/services"

enable_nat_gateway = true
single_nat_gateway = false

tags = {
  Department = "Meteorology"
  CostCenter = "Research"
  Jira       = "DD-4"
}
