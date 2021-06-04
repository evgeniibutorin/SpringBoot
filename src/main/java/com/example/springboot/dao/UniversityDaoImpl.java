package com.example.springboot.dao;

import com.example.springboot.model.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UniversityDaoImpl implements UniversityDao {

    EntityManager em;

    @Override
    public List<University> listUniversity() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<University> cq = cb.createQuery(University.class);
        Root<University> root = cq.from(University.class);
        cq.select(root);
        Query<University> query = (Query<University>) em.createQuery(cq);
        List<University> students = query.getResultList();
        return students;
    }
}
