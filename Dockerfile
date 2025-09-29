# Start from an official OpenJDK 17 image
FROM eclipse-temurin:17-jdk-jammy AS build

# Set working directory
WORKDIR /app

# Copy your application JAR file into the container
COPY target/*.jar app.jar

# Expose port (adjust if your app runs on another port)
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]