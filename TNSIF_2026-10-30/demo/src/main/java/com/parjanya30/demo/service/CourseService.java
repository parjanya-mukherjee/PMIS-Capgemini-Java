package com.parjanya30.demo.service;

import com.parjanya30.demo.entity.Course;
import com.parjanya30.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/*
 * The service contains the application's course rules.
 *
 * Controllers receive HTTP requests.
 * Services perform the work.
 * Repositories store and retrieve data.
 */
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final AtomicLong nextId = new AtomicLong(3);

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        course.setId(nextId.getAndIncrement());
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course existingCourse = courseRepository.findById(id);

        if (existingCourse == null) {
            return null;
        }

        existingCourse.setTitle(courseDetails.getTitle());
        existingCourse.setDescription(courseDetails.getDescription());
        return courseRepository.save(existingCourse);
    }

    public boolean deleteCourse(Long id) {
        if (courseRepository.findById(id) == null) {
            return false;
        }

        courseRepository.deleteById(id);
        return true;
    }
}