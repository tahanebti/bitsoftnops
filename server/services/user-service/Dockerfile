#Run
FROM openjdk:8-jre-slim

WORKDIR /app

COPY target/user-service-1.0.0.jar /app.jar

ENV JAR_FILE=user-service-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "$JAR_FILE"]