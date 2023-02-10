#Run
FROM openjdk:8-jre-slim


# Set the working directory
WORKDIR /app

# Copy the source code and pom.xml to the working directory
COPY . /app

# Build the application using Maven
#RUN ./mvnw clean install -f pom.xml -DskipTests 

COPY target/user-service-1.0.0.jar /app

ENV JAR_FILE=user-service-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "$JAR_FILE"]