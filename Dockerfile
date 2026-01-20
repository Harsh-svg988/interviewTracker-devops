# Use lightweight Java 17 runtime
FROM eclipse-temurin:17-jre

# Set working directory inside container
WORKDIR /app

# Copy the built jar into container
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
