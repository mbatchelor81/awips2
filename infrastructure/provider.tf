terraform {
  required_version = ">= 1.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }

  backend "s3" {
    bucket         = "PLACEHOLDER-terraform-state-bucket"
    key            = "awips2/edex/terraform.tfstate"
    region         = "us-east-1"
    encrypt        = true
    dynamodb_table = "PLACEHOLDER-terraform-locks"
  }
}

provider "aws" {
  region = var.aws_region

  default_tags {
    tags = {
      ManagedBy   = "Terraform"
      Project     = var.project_name
      Environment = var.environment
    }
  }
}
