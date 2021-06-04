package com.example.springboot.service;

import com.example.springboot.dao.CourseDao;
import com.example.springboot.model.Course;
import org.dozer.DozerBeanMapper;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    private final DozerBeanMapper beanMapper;

    public CourseServiceImpl(CourseDao courseDao, DozerBeanMapper beanMapper) {
        this.courseDao = courseDao;
        this.beanMapper = beanMapper;
    }

    @Override
    @Transactional
    public List<Course> findAllCourses() {
        List <Course> courses = courseDao.listCourses();
        for (Course course : courses) {
            Hibernate.initialize(course.getStudents());
        }
        return courses;
    }

    @Override
    @Transactional
    public List<Course> getCoursesByStudentName(String name) {
        List<Course> courses = courseDao.findCoursesByStudentName(name);
        for (Course course : courses) {
            Hibernate.initialize(course.getStudents());
        }
        return courses;
    }

    @Override
    @Transactional
    public List<Course> findExpensiveCourse() {
        List<Course> list = courseDao.findExpensiveCourse();
        return list;
    }

}
