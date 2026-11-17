package com.parjanya30.demo.repository;

import com.parjanya30.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * This repository connects Course objects with the MySQL database.
 *
 * JpaRepository provides built-in CRUD operations:
 * findAll(), findById(), save(), deleteById().
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
