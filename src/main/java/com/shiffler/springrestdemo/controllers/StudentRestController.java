package com.shiffler.springrestdemo.controllers;

import com.shiffler.springrestdemo.entities.Student;
import com.shiffler.springrestdemo.errors.StudentErrorResponse;
import com.shiffler.springrestdemo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //Will cause this method to be run after the object is created
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Billy","Bob"));
        theStudents.add(new Student("Violet","Shiffler"));
        theStudents.add(new Student("Garrett","Shiffler"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;  //Spring REST will use Jackson to convert the POJO data to JSON
    }

    //The @Path Variable matches up with the {studentId} in the GetMapping
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check to see if the studentId is out of bounds
        if ((studentId > theStudents.size() - 1 ) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }





}
