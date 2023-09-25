FROM openjdk:11

COPY target/yugi.jar yugi.jar

CMD ["java", "-jar", "/app.jar"]