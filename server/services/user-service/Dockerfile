
FROM openjdk:8-jdk-alpine AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN ./mvnw -B package --file pom.xml -DskipTests

FROM openjdk:8-jre-slim
#COPY target/user-service-1.0.0.jar /app/user-service-1.0.0.jar
COPY --from=build /workspace/target/user-service-1.0.0.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
