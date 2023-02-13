#FROM openjdk:8-jdk-alpine
#
# Build stage
#
FROM maven:3.8.3-openjdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN ./mvnw -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/user-service-1.0.0.jar /usr/local/lib/user-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/user-service.jar"]
