FROM openjdk:23-jdk-slim
ARG JAR_FILE=target/Artianction-1.0.jar
COPY${JAR_FILE} app_Artianction.jar
EXPOSE 8080
ENTRYPOINT  ["java", "-jar", "app_Artianction.jar"]