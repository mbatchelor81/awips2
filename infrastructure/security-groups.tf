resource "aws_security_group" "alb" {
  name_prefix = "${var.project_name}-${var.environment}-alb-"
  description = "Security group for Application Load Balancer"
  vpc_id      = aws_vpc.main.id

  tags = merge(
    var.tags,
    {
      Name        = "${var.project_name}-${var.environment}-alb-sg"
      Environment = var.environment
      Project     = var.project_name
      Purpose     = "alb"
    }
  )

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_vpc_security_group_ingress_rule" "alb_http" {
  security_group_id = aws_security_group.alb.id
  description       = "Allow HTTP traffic from internet"
  cidr_ipv4         = "0.0.0.0/0"
  from_port         = 80
  to_port           = 80
  ip_protocol       = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-alb-http-ingress"
    }
  )
}

resource "aws_vpc_security_group_ingress_rule" "alb_https" {
  security_group_id = aws_security_group.alb.id
  description       = "Allow HTTPS traffic from internet"
  cidr_ipv4         = "0.0.0.0/0"
  from_port         = 443
  to_port           = 443
  ip_protocol       = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-alb-https-ingress"
    }
  )
}

resource "aws_vpc_security_group_egress_rule" "alb_to_app" {
  security_group_id            = aws_security_group.alb.id
  description                  = "Allow traffic to application on EDEX HTTP port"
  referenced_security_group_id = aws_security_group.application.id
  from_port                    = var.edex_http_port
  to_port                      = var.edex_http_port
  ip_protocol                  = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-alb-to-app-egress"
    }
  )
}

resource "aws_security_group" "application" {
  name_prefix = "${var.project_name}-${var.environment}-app-"
  description = "Security group for AWIPS2 EDEX application workloads"
  vpc_id      = aws_vpc.main.id

  tags = merge(
    var.tags,
    {
      Name        = "${var.project_name}-${var.environment}-app-sg"
      Environment = var.environment
      Project     = var.project_name
      Purpose     = "application"
    }
  )

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_vpc_security_group_ingress_rule" "app_edex_from_alb" {
  security_group_id            = aws_security_group.application.id
  description                  = "Allow EDEX HTTP traffic from ALB"
  referenced_security_group_id = aws_security_group.alb.id
  from_port                    = var.edex_http_port
  to_port                      = var.edex_http_port
  ip_protocol                  = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-app-edex-from-alb-ingress"
    }
  )
}

resource "aws_vpc_security_group_ingress_rule" "app_postgres_internal" {
  security_group_id            = aws_security_group.application.id
  description                  = "Allow PostgreSQL traffic within application tier"
  referenced_security_group_id = aws_security_group.application.id
  from_port                    = var.postgres_port
  to_port                      = var.postgres_port
  ip_protocol                  = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-app-postgres-internal-ingress"
    }
  )
}

resource "aws_vpc_security_group_ingress_rule" "app_messaging_internal" {
  security_group_id            = aws_security_group.application.id
  description                  = "Allow messaging traffic within application tier"
  referenced_security_group_id = aws_security_group.application.id
  from_port                    = var.messaging_port
  to_port                      = var.messaging_port
  ip_protocol                  = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-app-messaging-internal-ingress"
    }
  )
}

resource "aws_vpc_security_group_egress_rule" "app_all_traffic" {
  security_group_id = aws_security_group.application.id
  description       = "Allow all outbound traffic for external dependencies"
  cidr_ipv4         = "0.0.0.0/0"
  ip_protocol       = "-1"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-app-all-egress"
    }
  )
}

resource "aws_security_group" "database" {
  name_prefix = "${var.project_name}-${var.environment}-db-"
  description = "Security group for PostgreSQL database"
  vpc_id      = aws_vpc.main.id

  tags = merge(
    var.tags,
    {
      Name        = "${var.project_name}-${var.environment}-db-sg"
      Environment = var.environment
      Project     = var.project_name
      Purpose     = "database"
    }
  )

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_vpc_security_group_ingress_rule" "db_postgres_from_app" {
  security_group_id            = aws_security_group.database.id
  description                  = "Allow PostgreSQL traffic from application tier only"
  referenced_security_group_id = aws_security_group.application.id
  from_port                    = var.postgres_port
  to_port                      = var.postgres_port
  ip_protocol                  = "tcp"

  tags = merge(
    var.tags,
    {
      Name = "${var.project_name}-${var.environment}-db-postgres-from-app-ingress"
    }
  )
}
