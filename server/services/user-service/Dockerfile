# Use an official Maven image as the base image
FROM maven:1.8-jdk-8-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Download the dependencies specified in the pom.xml file
#RUN mvn dependency:go-offline -B

# Copy the rest of the project files to the container
COPY . .

# Build the project
#RUN mvn clean install

# Set the entry point for the container
CMD ["java", "-jar", "target/user-service-1.0.0.jar"]
