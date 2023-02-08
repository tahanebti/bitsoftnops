#Run
FROM openjdk:8-jre-slim
ADD ./target/user-service-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]