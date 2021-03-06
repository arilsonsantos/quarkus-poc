####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode
#
# Before building the docker image run:
#
# mvn package -Pnative -Dquarkus.native.container-build=true
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/quarkus
#
###
# FROM registry.access.redhat.com/ubi8/ubi-minimal:8.1
FROM alpine:3.7
WORKDIR /work/
#COPY --chown=1001:root target/*-runner /work/application
COPY target/*-runner /work/application
RUN chmod +x /work/application

EXPOSE 8080
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]