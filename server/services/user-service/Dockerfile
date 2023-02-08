#Maven Build
FROM maven:3.8.3-openjdk-8-slim AS builder
# Set image information, but could be set to different location from command line
ARG IMAGE_VERSION="0.0.1-SNAPSHOT"
ARG IMAGE_NAME="user-service"
ARG MAINTAINER="Taha Nebti <taha.nebti@gmail.com>"

LABEL version=${IMAGE_VERSION} name=${IMAGE_NAME} maintainer=${MAINTAINER}

ADD ./target/user-service-1.0.0.jar app.jar

# Expose the service to port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
