# Use a Java base image
FROM adoptopenjdk:17-jdk AS build

# Set the working directory
WORKDIR /app

# Copy the Maven configuration files
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create a new Docker image with only the JRE
FROM adoptopenjdk:17-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build environment
COPY --from=build /app/target/hospital-0.0.1-SNAPSHOT.jar .

# Expose the port on which your Spring Boot application listens
EXPOSE 8080

# Set the command to run your application
CMD ["java", "-jar", "hospital-0.0.1-SNAPSHOT.jar"]