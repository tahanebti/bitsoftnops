#Run
FROM openjdk:8-jre-slim

WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN ./mvnw -P docker-build -DskipTests=true -f /app/pom.xml clean package install

ADD ./target/user-service-1.0.0.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
