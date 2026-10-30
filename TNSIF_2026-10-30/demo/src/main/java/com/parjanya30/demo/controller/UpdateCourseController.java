package com.parjanya30.demo.controller;

import com.parjanya30.demo.entity.Course;
import com.parjanya30.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller demonstrates PUT /courses/{courseId}.
 *
 * PUT is used when the client wants to replace or update existing data.
 * The ID comes from the URL and the new values come from the JSON body.
 */
@RestController
@RequestMapping("/courses")
public class UpdateCourseController {

    private final CourseService courseService;

    public UpdateCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long courseId,
            @RequestBody Course courseDetails) {

        Course updatedCourse = courseService.updateCourse(courseId, courseDetails);

        if (updatedCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(updatedCourse);
    }
}