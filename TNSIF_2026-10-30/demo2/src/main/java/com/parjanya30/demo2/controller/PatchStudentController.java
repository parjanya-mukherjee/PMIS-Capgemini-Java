
package com.parjanya30.demo2.controller;

import com.parjanya30.demo2.entity.Student;
import com.parjanya30.demo2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class PatchStudentController {

    private final StudentService studentService;

    public PatchStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<Student> patchStudent(
            @PathVariable Long studentId,
            @RequestBody Student studentDetails) {

        Student updatedStudent =
                studentService.patchStudent(studentId, studentDetails);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }
}
