# Azure-Spring-Function

This is a sample application to showcase how to incorporate the spring boot functionality to Azure functions using
Spring Cloud Function.

### Run the Function locally

#### You must specify a value for `AzureWebJobsStorage` in your local.settings.json for all functions except Http Triggered functions

- First you need to package your application into a Jar file
  `gradle azureFunctionsPackage`


- Run the function
  `gradle azureFunctionsRun`

The Azure Function should now be available on your localhost, using port 7071. You can test the function by sending it a
GET request. For example, using cURL

`curl --location --request GET 'http://localhost:7071/api/welcome?name=Joyal'`

### Running tests

`gradle test`

### References

https://docs.microsoft.com/en-us/azure/developer/java/spring-framework/getting-started-with-spring-cloud-function-in-azure

