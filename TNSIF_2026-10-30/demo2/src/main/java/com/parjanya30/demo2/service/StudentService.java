
package com.parjanya30.demo2.service;

import com.parjanya30.demo2.entity.Student;
import com.parjanya30.demo2.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/*
 * This service handles all business logic related to students.
 *
 * It communicates with StudentRepository to store and retrieve
 * student records from the in-memory storage.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final AtomicLong nextId = new AtomicLong(3);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Create a new student
    public Student createStudent(Student student) {
        student.setId(nextId.getAndIncrement());
        return studentRepository.save(student);
    }

    // Update all student details using PUT
    public Student updateStudent(Long id, Student studentDetails) {

        Student existingStudent = studentRepository.findById(id);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setCourse(studentDetails.getCourse());

        return studentRepository.save(existingStudent);
    }

    // Partially update student details using PATCH
    public Student patchStudent(Long id, Student details) {

        Student existingStudent = studentRepository.findById(id);

        if (existingStudent == null) {
            return null;
        }

        if (details.getName() != null) {
            existingStudent.setName(details.getName());
        }

        if (details.getEmail() != null) {
            existingStudent.setEmail(details.getEmail());
        }

        if (details.getCourse() != null) {
            existingStudent.setCourse(details.getCourse());
        }

        return studentRepository.save(existingStudent);
    }

    // Delete student by ID
    public boolean deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }
}
