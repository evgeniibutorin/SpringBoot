package com.example.springboot.dao;

import com.example.springboot.model.Course;

import java.util.List;

public interface CourseDao {
    List<Course> listCourses();
    List<Course> findCoursesByStudentName(String studentName);
    List<Course> findExpensiveCourse();
}
