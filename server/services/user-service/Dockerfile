#FROM openjdk:8-jdk-alpine
#
# Build stage
#
FROM maven:3.8.3-openjdk-8-slim AS build
COPY src /app
COPY pom.xml /app
RUN ./mvnw -f /app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=build target/user-service-1.0.0.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
