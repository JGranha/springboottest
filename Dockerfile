# All can be done without this Dockerfile, with just mvn spring-boot:build-image, but I did this for simplicity, since the project is small
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
