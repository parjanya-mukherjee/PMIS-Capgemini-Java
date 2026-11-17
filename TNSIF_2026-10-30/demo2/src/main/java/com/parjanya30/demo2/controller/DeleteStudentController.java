
package com.parjanya30.demo2.controller;

import com.parjanya30.demo2.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller handles DELETE /students/{studentId}.
 *
 * It removes a student using the given ID.
 * Successful deletion returns HTTP 204.
 */

@RestController
@RequestMapping("/students")
public class DeleteStudentController {

    private final StudentService studentService;

    public DeleteStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long studentId) {

        boolean deleted = studentService.deleteStudent(studentId);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
