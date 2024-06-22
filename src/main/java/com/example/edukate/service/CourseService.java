package com.example.edukate.service;

import com.example.edukate.dtos.coursedto.CourseCreateDto;
import com.example.edukate.dtos.coursedto.CourseDetailDto;
import com.example.edukate.dtos.coursedto.CourseDto;
import com.example.edukate.dtos.coursedto.CourseUpdateDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();
    CourseDto courseDto(Long id);
    void addCourse(CourseCreateDto courseCreateDto);
    void updateCourse(Long id, CourseUpdateDto courseUpdateDto);
    void deleteCourse(Long id);
}
