# Start with a base image that includes Java
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from the target directory to the container
COPY demo/demo/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your app runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]