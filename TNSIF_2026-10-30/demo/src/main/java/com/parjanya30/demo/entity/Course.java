package com.parjanya30.demo.entity;

/*
 * This class represents one course in our application.
 *
 * It is called an entity because it represents data that we want
 * to create, read, update, and delete through our REST API.
 */
public class Course {

    private Long id;
    private String title;
    private String description;

    public Course() {
        // Spring uses this empty constructor when it reads JSON from a request.
    }

    public Course(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}