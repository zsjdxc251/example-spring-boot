FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /usr/workspace/githome/example-spring-boot/example-spring-boot-docs/example-spring-boot-docs-quickstart/target/example-spring-boot-docs-quickstart.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]