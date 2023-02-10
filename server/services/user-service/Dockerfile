
FROM openjdk:8-jre-slim

# Set the working directory in the image to /app
WORKDIR /app

# Copy the pom.xml file to the image
COPY server/services/user-service/ /app/

# Run Maven to download the project dependencies
RUN chmod +x ./mvnw

# Build the application using Maven
RUN ./mvnw clean install -DskipTests 

# Run the application when the container starts
CMD java -jar target/user-service-1.0.0.jar
