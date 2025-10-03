# AWIPS EDEX Docker Container

Docker configuration for running the AWIPS EDEX (Environmental Data EXchange) server on Rocky Linux 8.

## Overview

This Docker setup provides a containerized AWIPS EDEX server for:
- Development and testing of AWIPS backend components
- Validating changes using the Python API (python-awips)
- Running EDEX without requiring a full CentOS/RHEL installation

## Prerequisites

- Docker Engine 20.10 or later
- Docker Compose v2 or later
- At least 16 CPU cores and 24GB RAM available for the container
- 700GB+ disk space for data storage (configurable via volumes)

## Quick Start

### 1. Build the Docker Image

```bash
cd docker
docker-compose build
```

This will create a Rocky Linux 8 based image with AWIPS EDEX 23.4.1 installed.

### 2. Run the Container

```bash
docker-compose up -d
```

The container will start all EDEX services in the correct order:
1. PostgreSQL database
2. httpd-pypies
3. Qpid message broker
4. EDEX services (request, ingest, ingestGrib)
5. LDM (if configured)

### 3. Monitor Startup

```bash
docker-compose logs -f edex
```

Wait for the message: "All services started. EDEX is now operational."

### 4. Verify Services

Check that EDEX is running:

```bash
docker exec awips-edex ps aux | grep edex
```

Test the API endpoint:

```bash
curl http://localhost:9581/services
```

## Connecting with Python API

To connect to the containerized EDEX server using python-awips:

```python
from awips.dataaccess import DataAccessLayer

DataAccessLayer.changeEDEXHost("localhost")

request = DataAccessLayer.newDataRequest("obs")
```

## Configuration

### Environment Variables

Set in `docker-compose.yml`:

- `AW_SITE_IDENTIFIER`: Site identifier (default: OAX)

### LDM Data Feeds

Edit `config/ldmd.conf.template` to configure which data feeds to ingest.

**Warning**: Requesting full radar and gridded model feeds will generate significant data volume. Start with text products (IDS|DDPLUS) for testing.

### Resource Limits

Adjust CPU and memory limits in `docker-compose.yml` based on your needs:

```yaml
deploy:
  resources:
    limits:
      cpus: '16'
      memory: 24G
```

## Data Persistence

The following volumes are created for data persistence:

- `edex-data`: Processed EDEX data
- `edex-database`: PostgreSQL database
- `edex-hdf5`: HDF5 data files
- `ldm-data`: LDM configuration and queue
- `data-store`: Raw data store

To reset all data:

```bash
docker-compose down -v
```

## Ports

- **9581**: HTTP/Thrift API endpoint for CAVE clients and Python API
- **9582**: PyPIES HTTP service

## Troubleshooting

### Container fails to start

Check logs:
```bash
docker-compose logs edex
```

### Services not starting

Verify resources are available:
```bash
docker stats awips-edex
```

### PostgreSQL initialization fails

Remove the database volume and restart:
```bash
docker-compose down
docker volume rm docker_edex-database
docker-compose up -d
```

### Out of memory errors

Increase memory limits in `docker-compose.yml` or reduce data feeds in `ldmd.conf.template`.

### Cannot connect with Python API

1. Verify EDEX is running: `docker-compose ps`
2. Check port mapping: `docker-compose port edex 9581`
3. Test endpoint: `curl http://localhost:9581/services`

## Development Workflow

For development and testing of AWIPS code changes:

1. Make code changes on your development machine
2. Build updated RPMs (if needed)
3. Rebuild the Docker image with changes
4. Run tests using Python API to validate

## Limitations

- This is a standalone EDEX server, not a distributed deployment
- LDM requires access to Unidata IDD (not available to public)
- For testing without IDD, manually place data files in `/awips2/data_store/ingest/`
- Resource requirements are for regional domains, not full CONUS

## References

- [AWIPS Installation Guide](https://unidata.github.io/awips2/install/install-edex/)
- [Python AWIPS Documentation](https://unidata.github.io/python-awips/)
- [Distributed EDEX](https://unidata.github.io/awips2/edex/distributed-computing/)

## Support

For issues or questions:
- GitHub Issues: https://github.com/mbatchelor81/awips2/issues
- Email: support-awips@unidata.ucar.edu
