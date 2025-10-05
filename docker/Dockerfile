FROM rockylinux:8

ENV AWIPS_VERSION=23.4.1

RUN dnf install -y 'dnf-command(config-manager)' && \
    dnf config-manager --set-enabled powertools && \
    dnf install -y epel-release && \
    dnf module enable -y postgresql:12 && \
    dnf install -y \
        postgresql \
        wget \
        bc \
        rsync \
        git \
        wgrib2 \
        curl \
        hostname \
        net-tools \
        procps-ng && \
    dnf clean all

RUN groupadd fxalpha && \
    useradd -G fxalpha awips && \
    echo "awips soft nproc 65536" >> /etc/security/limits.conf && \
    echo "awips soft nofile 65536" >> /etc/security/limits.conf

RUN mkdir -p /awips2/tmp /awips2/data_store /awips2/dev && \
    chown -R awips:fxalpha /awips2

RUN wget -O /etc/yum.repos.d/awips2.repo \
    https://downloads.unidata.ucar.edu/awips2/${AWIPS_VERSION}/linux/awips2.repo && \
    sed -i 's/enabled=0/enabled=1/' /etc/yum.repos.d/awips2.repo

RUN dnf --disableexcludes=main install -y awips2-*post* && \
    dnf --disableexcludes=main groupinstall -y awips2-server && \
    dnf clean all

RUN sed -i 's/enabled=1/enabled=0/' /etc/yum.repos.d/awips2.repo

RUN sed -i 's/@LDM_PORT@/388/' /awips2/ldm/etc/registry.xml

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

EXPOSE 9581 9582

WORKDIR /awips2/edex

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
