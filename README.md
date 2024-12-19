# System Info Exposer
## What is it?
This is a simple project allows you to get system information on the environment that the application runs on it.
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