#Run
FROM openjdk:8-jre-slim

COPY pom.xml /app/
COPY src /app/src

RUN ./mvnw clean install -DskipTests

ADD ./target/user-service-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]