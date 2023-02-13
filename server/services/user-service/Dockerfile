#Maven Build
FROM maven:3.8.3-openjdk-8-slim AS builder
COPY pom.xml /app/
COPY src /app/src
#RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package -DskipTests

#Run
FROM openjdk:8-jre-slim
ADD ./target/user-serivce-1.0.0.jar app.jar
EXPOSE 9007
ENTRYPOINT ["java", "-jar", "app.jar"]
