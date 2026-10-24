package com.jwt.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.project.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

}
