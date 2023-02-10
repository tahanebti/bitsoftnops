
FROM openjdk:8-jdk-alpine
COPY target/user-service-1.0.0.jar /app/user-service-1.0.0.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "user-service-1.0.0.jar"]
