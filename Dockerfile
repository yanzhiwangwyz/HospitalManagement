# Use the official Maven image as the build environment
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the build environment
WORKDIR /app

# Copy the pom.xml file to the build environment
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline -B

# Copy the source code to the build environment
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use the Eclipse Temurin JDK 17 Alpine image as the base image for the final container
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the final container
WORKDIR /app

# Copy the built JAR file from the build environment
COPY --from=build /app/target/hospital-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port on which your Spring Boot application listens
EXPOSE 8080

# Set the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"] 



































































# # Use Ubuntu as the base image
# FROM ubuntu:latest

# # Install dependencies
# RUN apt-get update && apt-get install -y curl git maven

# # Set up Java 17
# RUN curl -sL https://github.com/adoptium/temurin17-binaries/releases/latest/download/install-jdk17.sh -o install-jdk17.sh
# RUN chmod +x install-jdk17.sh
# RUN ./install-jdk17.sh --target /usr/lib/jvm/java-17-adoptium

# # Set environment variables
# ENV JAVA_HOME=/usr/lib/jvm/java-17-adoptium
# ENV PATH="$PATH:$JAVA_HOME/bin"

# # Copy the Java Spring Boot application
# COPY . /app

# # Set the working directory
# WORKDIR /app

# # Build the application with Maven
# RUN mvn clean package

# # Expose the port used by the Spring Boot application (adjust if needed)
# EXPOSE 8080

# # Run the Java Spring Boot application
# CMD java -jar target/hospital-0.0.1-SNAPSHOT.jar
