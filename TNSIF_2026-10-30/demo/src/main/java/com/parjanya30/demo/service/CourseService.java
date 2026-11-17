package com.parjanya30.demo.service;

import com.parjanya30.demo.entity.Course;
import com.parjanya30.demo.repository.CourseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

/*
 * The service contains the application's course rules.
 *
 * Controllers receive HTTP requests.
 * Services perform the work.
 * Repositories communicate with the MySQL database.
 */

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // GET ALL COURSES
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // GET COURSE BY ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // CREATE COURSE
    public Course createCourse(Course course) {
        course.setId(null);
        return courseRepository.save(course);
    }

    // UPDATE COURSE
    public Course updateCourse(Long id, Course courseDetails) {

        Course existingCourse = courseRepository.findById(id)
                .orElse(null);

        if (existingCourse == null) {
            return null;
        }

        existingCourse.setTitle(courseDetails.getTitle());
        existingCourse.setDescription(courseDetails.getDescription());

        return courseRepository.save(existingCourse);
    }

    // DELETE COURSE
    public boolean deleteCourse(Long id) {

        if (!courseRepository.existsById(id)) {
            return false;
        }

        courseRepository.deleteById(id);
        return true;
    }
}