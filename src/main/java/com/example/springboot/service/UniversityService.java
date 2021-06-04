package com.example.springboot.service;

import com.example.springboot.dto.UniversityDto;

import java.util.List;

public interface UniversityService {
    List<UniversityDto> findAllUniversity();
}
