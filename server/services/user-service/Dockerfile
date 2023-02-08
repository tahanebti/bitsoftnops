#Run
FROM openjdk:8-jre-slim

# Install Apache Maven
RUN apt-get update && \
    apt-get install -y maven


# Build the application using Maven
RUN mvn clean install --file pom.xml -DskipTests

COPY target/user-service-1.0.0.jar app.jar

#ENV JAR_FILE=user-service-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]