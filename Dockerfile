# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file of your Spring Boot application to the container
COPY target/your-application.jar /app/your-application.jar

# Expose port 8080 (default port for Spring Boot)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/your-application.jar"]
