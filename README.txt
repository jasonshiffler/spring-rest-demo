This is a basic Spring Boot REST controller. The project was created using the Spring Boot InitializerThe project
demonstrates how to configure a basic REST API for data access. The project contains basic error handling in the case
that either a search returns an empty result or the search request is not formatted correctly. Jackson is used to
convert POJOs to JSON and vice versa. There is no database backend for this project, the data is simply loaded in
memory. These are the classes that are part of the project:

SpringRestDemoApplication - Main Method, no changes made here.

StudentRestController - Controller with resource mappings. Students can be retrieved in bulk or by id. If a Student
isn't found a StudentNotFoundException is thrown. An @PostConstruct method is used to load the data.

StudentRestExceptionHandler - @ControllerAdvice class with two @ExceptionHandlers. One method handles data not found
and the other deals with generic exceptions. The @ControllerAdvice annotion allows the class to intercept traffic to the
controller and respond to exceptions.

Student - This is our entity definition. Lombok is used so we don't have to explicitly define all of the getters
and setters.

StudentErrorResponse - Defines the format used in our error response. Used by the @ExceptionHandler methods.

StudentNotFoundException - This is an extension of runtime exception that is thrown when a student isn't found