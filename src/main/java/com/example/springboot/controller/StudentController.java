package com.example.springboot.controller;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student")
    public List<StudentDto> getStudent() {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentService.findAllStudent());
    }

    @GetMapping("student/find")
    public List<StudentDto> getStudentsByCourse(@RequestParam(value = "name") String name) {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentService.getStudentByCourseName(name));
    }


    @GetMapping("student/cost")
    public List<StudentDto> getStudentByCoursesCost(@RequestParam(value = "cost") String cost) {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentService.findStudentByCoursesCost(Integer.parseInt(cost)));
    }

    @GetMapping("/student/cost/more")
    public List<StudentDto> getStudentWithExpensiveCourse(@RequestParam(value = "cost") String cost) {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentService.getStudentsWithExpensiveCourse(cost));
    }

    @GetMapping("/students/from/list")
    public List<StudentDto> getStudentInList() {
        StudentDto studentDto = new StudentDto();
        return studentDto.getStudentDtoList(studentService.getStudentInList());
    }

}
