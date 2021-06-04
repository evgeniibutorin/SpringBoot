package com.example.springboot.dao;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class HibernateBuildInCriterion {
    private static final int PARAMETER_LIMIT = 800;

    public static Criterion buildInCriterion1(String propertyName, List<?> values, CriteriaBuilder criteriaBuilder) { // пимер с 1001
        Criterion criterion = null;
        Predicate predicate = null;
        int listSize = values.size();//1001 размер списка параметров
        for (int i = 0; i < listSize; i += PARAMETER_LIMIT) {//0 1001 800 потом? 00 1001 1600 не понятно i += PARAMETER_LIMIT эквивалент i = i+PARAMETER_LIMIT Зачем?
            List<?> subList;
            if (listSize > i + PARAMETER_LIMIT) {
                subList = values.subList(i, (i + PARAMETER_LIMIT));
            } else {
                subList = values.subList(i, listSize);
            }

            if (predicate != null) {
                criterion = Restrictions.or(criterion, Restrictions.in(propertyName, subList));
            } else {
                criterion = Restrictions.in(propertyName, subList);
            }
        }
        return criterion;
    }

}
