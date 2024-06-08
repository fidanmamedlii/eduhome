package com.example.edukate.service.impl;

import com.example.edukate.dtos.coursedto.CourseCreateDto;
import com.example.edukate.dtos.coursedto.CourseDetailDto;
import com.example.edukate.dtos.coursedto.CourseDto;
import com.example.edukate.dtos.coursedto.CourseUpdateDto;
import com.example.edukate.models.Course;
import com.example.edukate.models.Instructor;
import com.example.edukate.repositories.CourseRepository;
import com.example.edukate.repositories.InstructorRepository;
import com.example.edukate.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDto> getCourses() {
        return courseRepository.findAll().stream()
                .filter(course -> !course.isDeleted())
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getHomeCourses() {
        return courseRepository.findAll().stream()
                .filter(course -> !course.isDeleted())
                .map(course -> modelMapper.map(course, CourseDto.class))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDetailDto courseDetail(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return modelMapper.map(course, CourseDetailDto.class);
    }

    @Override
    public void addCourse(CourseCreateDto courseCreateDto) {
        Course course = modelMapper.map(courseCreateDto, Course.class);

        if (courseCreateDto.getInstructorId() != null) {
            Instructor instructor = instructorRepository.findById(courseCreateDto.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
            course.setInstructor(instructor);
        }

        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Long id, CourseUpdateDto courseUpdateDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        modelMapper.map(courseUpdateDto, course);

        if (courseUpdateDto.getInstructorId() != null) {
            Instructor instructor = instructorRepository.findById(courseUpdateDto.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
            course.setInstructor(instructor);
        }

        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setDeleted(true);
        courseRepository.save(course);
    }
}
