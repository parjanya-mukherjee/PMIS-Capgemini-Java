package com.parjanya30.demo.controller;

import com.parjanya30.demo.entity.Course;
import com.parjanya30.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller demonstrates POST /courses.
 *
 * POST is used when the client wants to add new data.
 * @RequestBody converts the JSON request body into a Course object.
 */
@RestController
@RequestMapping("/courses")
public class CreateCourseController {

    private final CourseService courseService;

    public CreateCourseController(CourseService courseService) {

        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody
                                                   Course course) {
        Course savedCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                savedCourse);
    }
}