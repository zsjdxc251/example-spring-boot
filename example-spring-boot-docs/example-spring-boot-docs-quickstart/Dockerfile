FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/example-spring-boot-docs-quickstart.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]