
FROM openjdk:8-jre-slim

# Set the working directory in the image to /app
WORKDIR /app

# Copy the pom.xml file to the image
COPY pom.xml .

# Run Maven to download the project dependencies
RUN ./mvnw -B dependency:resolve

# Copy the rest of the application code to the image
COPY . .

# Build the application using Maven
RUN ./mvnw -B package

# Run the application when the container starts
CMD java -jar target/user-service-1.0.0.jar
