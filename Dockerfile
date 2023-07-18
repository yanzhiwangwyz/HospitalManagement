# Use Ubuntu as the base image
FROM ubuntu:latest

# Install dependencies
RUN apt-get update && apt-get install -y curl git maven

# Set up Java 17
RUN curl -sL https://github.com/adoptium/temurin17-binaries/releases/latest/download/install-jdk17.sh -o install-jdk17.sh
RUN chmod +x install-jdk17.sh
RUN ./install-jdk17.sh --target /usr/lib/jvm/java-17-adoptium

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-adoptium
ENV PATH="$PATH:$JAVA_HOME/bin"

# Copy the Java Spring Boot application
COPY . /app

# Set the working directory
WORKDIR /app

# Build the application with Maven
RUN mvn clean package

# Expose the port used by the Spring Boot application (adjust if needed)
EXPOSE 8080

# Run the Java Spring Boot application
CMD java -jar target/hospital-0.0.1-SNAPSHOT.jar
