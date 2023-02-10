#Run
FROM openjdk:8-jre-slim

WORKDIR /app
#COPY src /app/src
#COPY pom.xml /app
RUN ./mvnw -DskipTests=true clean package install

ADD ./target/user-service-1.0.0.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
