package com.example.springboot.config;

import com.example.springboot.dto.CourseDto;
import com.example.springboot.dto.StudentDto;
import com.example.springboot.dto.UniversityDto;
import com.example.springboot.model.Course;
import com.example.springboot.model.Student;
import com.example.springboot.model.University;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    public BeanMappingBuilder beanMappingBuilder(){
       return new BeanMappingBuilder() {
           @Override
           protected void configure() {
               mapping(Student.class, StudentDto.class);
               mapping(University.class, UniversityDto.class);
               mapping(Course.class, CourseDto.class)
               .fields("courseCost","cost");
           }
       };
    }
    @Bean
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }

}