
package com.parjanya30.demo2.controller;

import com.parjanya30.demo2.entity.Student;
import com.parjanya30.demo2.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * This controller handles GET /students.
 *
 * It returns all students available in the repository.
 */

@RestController
@RequestMapping("/students")
public class GetAllStudentsController {

    private final StudentService studentService;

    public GetAllStudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
