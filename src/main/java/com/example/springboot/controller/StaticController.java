package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping("/student_home_page")
    public String getStudentStartedPage() {
        return "student_home_page";
    }

    @GetMapping("/course_home_page")
    public String getCourseStartedPage() {
        return "course_home_page";
    }

    @GetMapping("/university_home_page")
    public String getUniversityStartedPage() {
        return "university";
    }

}
