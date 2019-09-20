package com.shiffler.springrestdemo.controllers;

import com.shiffler.springrestdemo.errors.StudentErrorResponse;
import com.shiffler.springrestdemo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Want to return an error if the student isn't found. Note how it takes a StudentNotFoundException in the
    //method signature
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),
                exc.getMessage(), System.currentTimeMillis());

        //Spring REST will use Jackson to convert the POJO data to JSON
        //This HttpStatus is in the actual HTTP header, not the StudentErrorResponse Object
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    //Want to return an error for any generic exception such as bad data. Note how it takes an Exception in the
    //method signature
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exc) {

        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(), System.currentTimeMillis());

        //Spring REST will use Jackson to convert the POJO data to JSON
        //This HttpStatus is in the actual HTTP header, not the StudentErrorResponse Object
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }
}