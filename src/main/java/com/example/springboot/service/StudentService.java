package com.example.springboot.service;

import com.example.springboot.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
//    List<Student> getStudentByCourseName(String name);
//    List<Student> findStudentByCoursesCost(int cost);
//    List<Student> getStudentsWithExpensiveCourse(String cost);
//    List<Student> getStudentInList();
}
