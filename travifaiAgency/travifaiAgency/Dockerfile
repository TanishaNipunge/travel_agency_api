# Use an official Java runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/travifaiAgency-0.0.1-SNAPSHOT.jar app.jar 

# Expose port 8080
EXPOSE 8085

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
