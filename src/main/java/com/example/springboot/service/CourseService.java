package com.example.springboot.service;

import com.example.springboot.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    List<Course> getCoursesByStudentName(String name);
    List<Course> findExpensiveCourse();
}
