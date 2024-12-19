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

## How to get the token?

**Using the Token in the Application**

1. **Finding the Generated Token in the Logs**  
   When the application starts, it generates a token and logs it for your reference. To find the token:  
   - Look for a log entry similar to the following:  
     ```
     2024-12-19T13:10:35.718+01:00 INFO 7399 --- [exposer] [restartedMain] c.glinboy.exposer.security.TokenFilter : A token generated: f2e39634-0ee6-4b68-b904-0e39c0d448cb
     ```  
   - The token is the value displayed after "A token generated:" (e.g., `f2e39634-0ee6-4b68-b904-0e39c0d448cb`).

2. **Setting the Token Using an Environment Variable**  
   If you prefer to specify a custom token, you can set it using the environment variable:  
   - `application.api.token-value`  
   Example:  
   ```bash
   export application.api.token-value=your-custom-token
   ```  
   Replace `your-custom-token` with your desired token value.

By following these steps, you can either retrieve the token from the logs or set it manually as needed.

## Access API

**Accessing the API Documentation and Making Requests**

1. **OpenAPI/Swagger UI**  
   The application provides an OpenAPI/Swagger UI for exploring and testing the available APIs.  
   - You can access it in your browser at:  
     **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**  
   - The Swagger UI offers a user-friendly interface to view the API documentation, inspect available endpoints, and test them directly from the browser.

2. **Using cURL for API Requests**  
   You can also interact with the API using cURL commands. For example:  
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

### Notes:
- Ensure the application is running before accessing the Swagger UI or making cURL requests.
- Adjust the host and port if the application is configured to run on a different address or port.

With the Swagger UI and cURL, you can efficiently explore and interact with the application's APIs.