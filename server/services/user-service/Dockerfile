
FROM openjdk:8-jre-slim
ARG JAR_FILE=./target/user-service-1.0.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]