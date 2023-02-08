#Run
FROM openjdk:8-jre-slim

# Install Apache Maven
RUN apt-get update && \
    apt-get install -y maven


# Set the working directory
WORKDIR /app

# Copy the source code and pom.xml to the working directory
COPY . /app

# Build the application using Maven
RUN mvn clean install -f pom.xml -DskipTests

COPY target/user-service-1.0.0.jar app.jar

#ENV JAR_FILE=user-service-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]