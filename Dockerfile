# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper scripts and the POM file
COPY mvnw pom.xml ./

# Copy the Maven wrapper and settings
COPY .mvn .mvn

# Download the Maven dependencies
RUN ./mvnw dependency:go-offline -B

# Copy the source code into the container
COPY src ./src

# Package the application
RUN ./mvnw package -DskipTests

# Expose port 8080 (default port for Spring Boot)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "./target/parcel-scanner-v1.jar"]
