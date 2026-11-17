
package com.parjanya30.demo2.controller;

import com.parjanya30.demo2.entity.Student;
import com.parjanya30.demo2.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller handles POST /students.
 *
 * It receives student details through the request body.
 * A new student is created and HTTP 201 is returned.
 */

@RestController
@RequestMapping("/students")
public class CreateStudentController {

    private final StudentService studentService;

    public CreateStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student) {

        Student savedStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedStudent);
    }
}
