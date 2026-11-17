package com.parjanya30.demo2.entity;

/*
 * This class represents a student in our application.
 *
 * It contains student details such as ID, name, email and course.
 * Objects of this class will be stored in our in-memory repository.
 */
public class Student {

    private Long id;
    private String name;
    private String email;
    private String course;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(Long id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}