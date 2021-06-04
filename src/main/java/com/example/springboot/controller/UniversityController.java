package com.example.springboot.controller;

import com.example.springboot.dto.UniversityDto;
import com.example.springboot.service.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("university")
    @ResponseBody
    public List<UniversityDto> getStudent() {
        List<UniversityDto> list = universityService.findAllUniversity();
        return list;
    }
}
