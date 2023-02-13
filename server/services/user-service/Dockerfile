FROM openjdk:8-jdk-alpine

WORKDIR /src

COPY /target/*.jar /src/user-service-1.0.0.jar

EXPOSE 8080

CMD [ "java", "-jar", "/src/user-service-1.0.0.jar" ]
