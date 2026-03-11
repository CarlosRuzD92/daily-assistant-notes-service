FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/notas-0.0.1.jar
COPY ${JAR_FILE} app_notas.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","/app_notas.jar"]
