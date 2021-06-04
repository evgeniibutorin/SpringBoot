package com.example.springboot.controller;

import com.example.springboot.dto.CourseDto;
import com.example.springboot.model.Course;
import com.example.springboot.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("course")
    public List<CourseDto> getCourses() {
        CourseDto courseDto = new CourseDto();
        List<Course> courses = courseService.findAllCourses();
        return courseDto.getCourseDtoList(courses);
    }

//    @GetMapping("/courses/find")
//    public List<CourseDto> getCoursesByStudentName(@RequestParam(value = "name") String name) {
//        CourseDto courseDto = new CourseDto();
//        return courseDto.getCourseDtoList(courseService.getCoursesByStudentName(name));
//    }

    @GetMapping("/expensive_courses")
    public List<CourseDto> getExpensiveCourse() {
        CourseDto courseDto = new CourseDto();
        return courseDto.getCourseDtoList(courseService.findExpensiveCourse());
    }

}
