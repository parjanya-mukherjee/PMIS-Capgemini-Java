
package com.parjanya30.demo2.repository;

import com.parjanya30.demo2.entity.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This repository stores student records in memory.
 *
 * ConcurrentHashMap stores students using their IDs as keys.
 * Initial sample students are added when the repository is created.
 */

@Repository
public class StudentRepository {

    private final Map<Long, Student> students =
            new ConcurrentHashMap<>();

    public StudentRepository() {

        students.put(1L, new Student(
                1L,
                "Rahul Sharma",
                "rahul@example.com",
                "Java"
        ));

        students.put(2L, new Student(
                2L,
                "Priya Singh",
                "priya@example.com",
                "Spring Boot"
        ));
    }

    // Get all students
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    // Get student by ID
    public Student findById(Long id) {
        return students.get(id);
    }

    // Add or update student
    public Student save(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    // Check whether student exists
    public boolean existsById(Long id) {
        return students.containsKey(id);
    }

    // Delete student
    public void deleteById(Long id) {
        students.remove(id);
    }
}
