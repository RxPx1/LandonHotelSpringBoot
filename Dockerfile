
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app


COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar


COPY src/main/resources/static angular-dist


EXPOSE 8080


CMD ["java", "-jar", "app.jar"]
