
package com.parjanya30.demo2.controller;

import com.parjanya30.demo2.entity.Student;
import com.parjanya30.demo2.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller handles PUT /students/{studentId}.
 *
 * It updates an existing student's details.
 * If the ID does not exist, it returns 404.
 */

@RestController
@RequestMapping("/students")
public class UpdateStudentController {

    private final StudentService studentService;

    public UpdateStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long studentId,
            @RequestBody Student studentDetails) {

        Student updatedStudent =
                studentService.updateStudent(studentId, studentDetails);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }
}
