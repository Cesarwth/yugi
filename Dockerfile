FROM openjdk:11

WORKDIR /app

COPY target/yugi.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]