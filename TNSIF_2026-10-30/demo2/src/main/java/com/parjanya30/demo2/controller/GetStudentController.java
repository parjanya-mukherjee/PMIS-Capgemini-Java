
package com.parjanya30.demo2.controller;

import com.parjanya30.demo2.entity.Student;
import com.parjanya30.demo2.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller handles GET /students/{studentId}.
 *
 * It returns a single student using the given ID.
 * If the student does not exist, it returns 404.
 */

@RestController
@RequestMapping("/students")
public class GetStudentController {

    private final StudentService studentService;

    public GetStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(
            @PathVariable Long studentId) {

        Student student = studentService.getStudentById(studentId);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }
}
