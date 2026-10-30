package com.parjanya30.demo.controller;



import com.parjanya30.demo.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This controller demonstrates DELETE /courses/{courseId}.
 *
 * DELETE is used when the client wants to remove data.
 * A successful delete returns HTTP 204 with no response body.
 */
@RestController
@RequestMapping("/courses")
public class DeleteCourseController {

    private final CourseService courseService;

    public DeleteCourseController(CourseService courseService) {

        this.courseService = courseService;
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId)
    {
        boolean deleted = courseService.deleteCourse(courseId);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}