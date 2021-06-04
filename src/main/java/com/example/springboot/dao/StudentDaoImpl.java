package com.example.springboot.dao;


import com.example.springboot.model.Course;
import com.example.springboot.model.Student;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {

    EntityManager em;


    @Override
    public List<Student> listStudents() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query<Student> query = (Query<Student>) em.createQuery(cq);
        List<Student> students = query.getResultList();
        return students;
    }

//    @Override
//    public List<Student> findStudentsByCoursesName(String courseName) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);// CriteriaQuery устанавливает функционал для запросов верхнего уровня
//        Root<Course> courseRoot = cq.from(Course.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
//        cq.where(cb.equal(courseRoot.get(Course_.courseName), courseName));
//        SetJoin<Course, Student> studentCourseSetJoin = courseRoot.join(Course_.students);
//        CriteriaQuery<Student> studentCriteriaQuery = cq.select(studentCourseSetJoin);
//        TypedQuery<Student> query = em.createQuery(studentCriteriaQuery);
//        List<Student> students = query.getResultList();
//        return students;
//    }
//
//    @Override
//    public List<Student> findStudentByCoursesCost(int cost) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);// CriteriaQuery устанавливает функционал для запросов верхнего уровня
//        Root<Course> courseRoot = cq.from(Course.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
//        cq.where(cb.equal(courseRoot.get(Course_.courseCost), cost));
//        SetJoin<Course, Student> studentCourseSetJoin = courseRoot.join(Course_.students);
//        CriteriaQuery<Student> studentCriteriaQuery = cq.select(studentCourseSetJoin);
//        TypedQuery<Student> query = em.createQuery(studentCriteriaQuery);
//        List<Student> students = query.getResultList();
//        return students;
//    }
//
//    @Override
//    public List<Student> findStudentWithExpensiveCourse(String cost) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);// CriteriaQuery устанавливает функционал для запросов верхнего уровня
//        Root<Course> courseRoot = cq.from(Course.class);//Root - корневой тип в from clause корни запросов всегда ссылаются на сущность
//        cq.where(cb.greaterThan(courseRoot.get("courseCost"), Integer.parseInt(cost)));
//        SetJoin<Course, Student> studentCourseSetJoin = courseRoot.join(Course_.students);
//        CriteriaQuery<Student> studentCriteriaQuery = cq.select(studentCourseSetJoin);
//        TypedQuery<Student> query = em.createQuery(studentCriteriaQuery);
//        List<Student> students = query.getResultList();
//        return students;
//    }

//    @Override
//    public List<Student> findStudentInSomeList() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> studentRoot = cq.from(Student.class);
//        final int PARAMETER_LIMIT = 800;
//        Predicate predicate = null;
//        List<Integer> studentIdes = new ArrayList<>();
//        for (int i = 0; i < 1003; i++) {
//            studentIdes.add(i);
//        }
//        int listSize = studentIdes.size();
//        for (int i = 0; i < listSize; i += PARAMETER_LIMIT) {
//            List<?> subList;
//            if (listSize > i + PARAMETER_LIMIT) {
//                subList = studentIdes.subList(i, (i + PARAMETER_LIMIT));
//            } else {
//                subList = studentIdes.subList(i, listSize);
//            }
//            if (predicate != null) {
//                predicate = cb.or(predicate, studentRoot.get(Student_.ID).in(subList));
//            } else {
//                predicate = studentRoot.get(Student_.ID).in(subList);
//            }
//        }
//        cq.select(studentRoot).where(predicate);
//        Query<Student> query = (Query<Student>) em.createQuery(cq);
//        List<Student> students = query.getResultList();
//        return students;
//    }
}
