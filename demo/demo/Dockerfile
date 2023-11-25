# Start from a base image that has Java installed
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file from the Maven build
COPY demo/demo/target/your-application.jar /app/

# Set the command to run the application when the container starts
CMD ["java", "-jar", "your-application.jar"]