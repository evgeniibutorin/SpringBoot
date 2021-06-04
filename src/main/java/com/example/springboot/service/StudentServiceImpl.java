package com.example.springboot.service;

import com.example.springboot.dao.StudentDAO;
import com.example.springboot.model.Student;
import org.dozer.DozerBeanMapper;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final DozerBeanMapper beanMapper;

    public StudentServiceImpl(StudentDAO studentDAO, DozerBeanMapper beanMapper) {
        this.studentDAO = studentDAO;
        this.beanMapper = beanMapper;
    }

    @Override
    @Transactional
    public List<Student> findAllStudent() {
        List<Student> students = studentDAO.listStudents();
        for (Student student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<Student> getStudentByCourseName(String name) {
        List<Student> students = studentDAO.findStudentsByCoursesName(name);
        for (Student student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<Student> findStudentByCoursesCost(int cost) {
        List<Student> students = studentDAO.findStudentByCoursesCost(cost);
        for (Student student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<Student> getStudentsWithExpensiveCourse(String cost) {
        List<Student> students = studentDAO.findStudentWithExpensiveCourse(cost);
        for (Student student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

    @Override
    @Transactional
    public List<Student> getStudentInList() {
        List<Student> students = studentDAO.findStudentInSomeList();
        for (Student student : students) {
            Hibernate.initialize(student.getCourses());
        }
        return students;
    }

}
