#Run
FROM openjdk:8-jre-slim

# Install Apache Maven
RUN apt-get update && \
    apt-get install -y maven

COPY pom.xml /app/
COPY src /app/src
#RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package -DskipTests


ADD ./target/user-service-1.0.0.jar app.jar
EXPOSE 9007
ENTRYPOINT ["java", "-jar", "app.jar"]