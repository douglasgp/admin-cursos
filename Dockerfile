FROM rmpestano/wildfly:15.0.1
MAINTAINER Rafael Pestano

COPY ./docker/standalone.conf ${WILDFLY_HOME}/bin/

COPY ./target/showcase.war ${DEPLOYMENT_DIR}