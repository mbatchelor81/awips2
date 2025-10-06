# AWIPS2 EDEX Dev Container

This Dev Container configuration provides a complete AWIPS2 EDEX development environment.

## Overview

This Dev Container adapts the production Docker setup from the `docker/` directory for development purposes. It provides:

- Full AWIPS EDEX 23.4.1 server on Rocky Linux 8
- Repository mounted at `/home/ubuntu/repos` for development
- Python and Java development tools
- PostgreSQL database, Qpid messaging, and EDEX services
- Flexible service startup (auto or manual)

## Requirements

- VS Code with Dev Containers extension
- Docker Engine 20.10 or later
- Docker Compose v2 or later
- At least 6 CPU cores and 20GB RAM available
- 100GB+ disk space for data storage

## Quick Start

### 1. Open in Dev Container

1. Open the `awips2` repository in VS Code
2. Press `F1` and select "Dev Containers: Reopen in Container"
3. Wait for the container to build and start (first time takes ~15 minutes)
4. Services will start automatically by default

### 2. Verify Services

Once the container is running and services have started:

```bash
# Check EDEX processes
ps aux | grep edex

# Test the API endpoint
curl http://localhost:9581/services

# View EDEX logs
tail -f /awips2/edex/logs/edex-*.log
```

### 3. Connect with Python API

```python
from awips.dataaccess import DataAccessLayer

DataAccessLayer.changeEDEXHost("localhost")
request = DataAccessLayer.newDataRequest("obs")
```

## Configuration

### Resource Limits

The Dev Container is configured for VMs with 8 cores and 31GB RAM:
- CPU Limit: 6 cores
- Memory Limit: 20GB
- CPU Reservation: 4 cores
- Memory Reservation: 12GB

Adjust in `.devcontainer/docker-compose.yml` if needed.

### Service Startup Control

By default, all EDEX services start automatically. To disable auto-start:

1. Edit `.devcontainer/docker-compose.yml`
2. Change: `AUTO_START_SERVICES=false`
3. Rebuild the container

With auto-start disabled, the container opens an interactive shell. You can manually start services by running the entrypoint script.

### LDM Data Feeds

Edit `.devcontainer/config/ldmd.conf.template` to configure data feeds.

**Warning:** Full radar and model feeds generate significant data volume. Start with text products (IDS|DDPLUS).

## Development Workflow

### Repository Access

The container mounts `/home/ubuntu/repos` from the host, giving you access to:
- The main `awips2` repository
- Other AWIPS2 repositories if cloned in the same parent directory

### Editing Code

- Use VS Code's editor inside the Dev Container
- Python and Java extensions are pre-configured
- Python interpreter: `/awips2/python/bin/python`
- Java home: `/awips2/java`

### Testing Changes

1. Make code changes in VS Code
2. Test using the running EDEX services
3. Validate with python-awips or by checking EDEX logs
4. Rebuild RPMs if needed (see build docs)

### Eclipse Development

The AWIPS Development Environment (ADE) can be installed for Eclipse-based development:

```bash
# Enable AWIPS repo
sudo sed -i 's/enabled=0/enabled=1/' /etc/yum.repos.d/awips2.repo

# Install ADE
sudo yum groupinstall awips2-ade -y

# Disable repo
sudo sed -i 's/enabled=1/enabled=0/' /etc/yum.repos.d/awips2.repo
```

**Note:** Eclipse is a GUI application. To use it from the container, you'll need X11 forwarding configured. Alternatively, use VS Code for editing and Eclipse only when necessary.

## Data Persistence

The following Docker volumes persist data between container rebuilds:

- `edex-data`: Processed EDEX data
- `edex-database`: PostgreSQL database
- `edex-hdf5`: HDF5 data files
- `ldm-data`: LDM configuration and queue
- `data-store`: Raw data store

To reset all data:

```bash
docker-compose -f .devcontainer/docker-compose.yml down -v
```

## Troubleshooting

### Container fails to start

Check logs:
```bash
docker-compose -f .devcontainer/docker-compose.yml logs edex-dev
```

### Services not starting

Verify resources:
```bash
docker stats awips-edex-dev
```

### PostgreSQL issues

Remove database volume and restart:
```bash
docker-compose -f .devcontainer/docker-compose.yml down
docker volume rm devcontainer_edex-database
docker-compose -f .devcontainer/docker-compose.yml up -d
```

### Out of memory

Increase limits in `docker-compose.yml` or reduce data feeds in `ldmd.conf.template`.

## Differences from Production Docker

- Reduced resource limits (6 cores/20GB vs 16 cores/24GB)
- Repository mounted for development
- awips user has sudo access
- Optional service auto-start
- Development tools pre-installed
- VS Code integration

## References

- [AWIPS Development Environment](../docs/dev/awips-development-environment.md)
- [Production Docker Setup](../docker/README.md)
- [Python AWIPS Documentation](https://unidata.github.io/python-awips/)
