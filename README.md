# System Info Exposer

## What is it?
This is a simple project allows you to get system information on the environment that the application runs on it.

## How to run?

**Running a Spring Boot Application**

You can run a Spring Boot application using Maven in two ways: with Maven installed on your system or by using the Maven Wrapper.

### 1. **Running with Maven Installed**
   If Maven is installed and configured on your system, you can run the application with the following command:  
   ```bash
   mvn spring-boot:run
   ```
   This command starts the application by executing the `spring-boot:run` goal defined in the Maven plugin.

### 2. **Running with the Maven Wrapper**
   The Maven Wrapper (`mvnw`) is included in most Spring Boot projects, allowing you to run the application without installing Maven globally.  

   - On Linux/macOS:  
     ```bash
     ./mvnw spring-boot:run
     ```

   - On Windows:  
     ```bash
     mvnw spring-boot:run
     ```

### Notes:
- Ensure you are in the root directory of your Spring Boot project, where the `pom.xml` file and the Maven Wrapper files (`mvnw`, `mvnw.cmd`, and `.mvn/`) are located.
- Both methods will start your Spring Boot application on the default port (usually `8080`), unless configured otherwise.

By using either of these commands, you can easily run your Spring Boot application for development or testing.

## cURL requests

- Get environment variables


  ```bash
    curl -X 'GET' \
  	'http://localhost:8080/api/v1/environment/variables' \
  	-H 'accept: */*' \
  	-H 'X-API-KEY: YOUR_API_KEY'
  ```

  or


  ```bash
    curl -X 'GET' \
  	'http://localhost:8080/api/v1/env/variables' \
  	-H 'accept: */*' \
  	-H 'X-API-KEY: YOUR_API_KEY'
  ```

- Get system properties


  ```bash
    curl -X 'GET' \
  	'http://localhost:8080/api/v1/system/properties' \
  	-H 'accept: */*' \
  	-H 'X-API-KEY: YOUR_API_KEY'
  ```

  or


  ```bash
    curl -X 'GET' \
  	'http://localhost:8080/api/v1/sys/properties' \
  	-H 'accept: */*' \
  	-H 'X-API-KEY: YOUR_API_KEY'
  ```