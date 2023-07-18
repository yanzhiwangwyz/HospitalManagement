## Hospital Management System 
- The hospital management system is a spring boot-based application designed to streamline the management of patient information in healthcare facilities. It serves as a centralized database that enables healthcare providers to register, organize, and keep track of patient records, ensuring efficient and accurate patient management throughout the healthcare journey 
## Technical Specifications 
- Spring Boot Dependency 
 - ![](./Initializr.png) 
- Model 
    - Department 
    - Patient 
    - Doctor 
    - Hospital 
- Relationship 
    - A department is associated with multiple patient and a patient is associated with multiple department 
    - A doctor can treat multiple patients, and a patient can consult multiple doctors 
    - A patient can be admitted to multiple hospitals, and a hospital can accommodate multiple patients 
    - ![](./HospitalManagement.png)
    - [dbdiagram](https://dbdiagram.io/d/64b0ac9102bd1c4a5e0db4d9) 
## Deploy in local 
- Go to directory where you have pom.xml
```
mvn clean package
```
- Go to target directory where you have JAR file 
```
java -jar hospital-0.0.1-SNAPSHOT.jar 
``` 
- This will start the embedded servlet container and deploy your Spring Boot application 
- Open localhost:8080
> Reference

> - [Change environment to Java version 17](https://docs.github.com/en/codespaces/setting-up-your-project-for-codespaces/adding-a-dev-container-configuration/setting-up-your-java-project-for-codespaces)
## Deploy with Docker 
```
docker build -t project .
```
```
docker run -p 8080:8080 project 
```
## Deploy on Render 
- Add `Dockerfile` to specify environment, specify working directory, and build the application using Maven 
[Hospital Management Project](https://project-6b4i.onrender.com/) 
## Deploy on Heroku 
- Add `Dockerfile` to specify environment, specify working directory, and build the application using Maven
- Add `Procfile` to specify the application to run the Java application using the assigned PORT 
- - Add `system.properties` to to specify the Java version 
[Hospital Management Project](https://hospitalmanagementapp-45c6aa8bdba4.herokuapp.com/) 




