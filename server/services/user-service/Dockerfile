#FROM openjdk:8-jdk-alpine
#
# Build stage
#
FROM maven:3.8.3-openjdk-8-slim AS builder

# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build

#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins

#Copy source code
COPY src /build/src

# Build application
RUN mvn package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=builder /build/target/user-service-1.0.0.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
