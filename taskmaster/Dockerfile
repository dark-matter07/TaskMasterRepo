FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/taskmaster-0.0.1-SNAPSHOT.jar app.jar  # Adjust JAR name if needed

ENTRYPOINT ["java", "-jar", "app.jar"]