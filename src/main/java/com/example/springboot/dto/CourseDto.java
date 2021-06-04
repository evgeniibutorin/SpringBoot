package com.example.springboot.dto;

import com.example.springboot.model.Course;
import com.example.springboot.model.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String courseName;

    @Getter
    @Setter
    int cost;

    @Getter
    @Setter
    Set<StudentDto> students = new HashSet<>();

    public List<CourseDto> getCourseDtoList(List<Course> courseList){
        List<CourseDto> courseDtoSet = new ArrayList<>();
        for (Course course:courseList){
            students = new HashSet<>();
            CourseDto courseDto = new CourseDto();
            courseDto.setId(course.getId());
            courseDto.setCourseName(course.getCourseName());
            courseDto.setCost(course.getCourseCost()+100);
            for (Student student:course.getStudents()){
                StudentDto studentDto = new StudentDto();
                studentDto.setId(student.getId());
                studentDto.setStudentName(student.getStudentName());
                studentDto.setCourses(null);
                students.add(studentDto);
            }
            courseDto.setStudents(students);
            courseDtoSet.add(courseDto);
        }
        return courseDtoSet;
    }

}

