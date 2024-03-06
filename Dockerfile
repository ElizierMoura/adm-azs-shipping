FROM openjdk:22-ea-21-slim-bullseye

WORKDIR /app

COPY target/azship-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]
