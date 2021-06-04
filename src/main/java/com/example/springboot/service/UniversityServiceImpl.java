package com.example.springboot.service;

import com.example.springboot.dao.UniversityDao;
import com.example.springboot.dto.UniversityDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityDao universityDao;
    private final DozerBeanMapper beanMapper;

    public UniversityServiceImpl(UniversityDao universityDao, DozerBeanMapper beanMapper) {
        this.universityDao = universityDao;
        this.beanMapper = beanMapper;
    }

    @Override
    @Transactional
    public List<UniversityDto> findAllUniversity() {
        List<UniversityDto> university = universityDao.listUniversity().stream()
                .map(student -> beanMapper.map(student, UniversityDto.class))
                .collect(Collectors.toList());
        return university;
    }
}