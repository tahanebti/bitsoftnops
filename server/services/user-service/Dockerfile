
FROM openjdk:8-jre-slim

WORKDIR /app

# Copy the jar file of the application to the container
COPY target/*.jar app.jar

# Set the environment variable for the application's main class
ENV JAVA_OPTS=""

# Expose the default port used by the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
