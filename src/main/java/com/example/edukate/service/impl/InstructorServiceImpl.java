package com.example.edukate.service.impl;

import com.example.edukate.dtos.instructordto.InstructorCreateDto;
import com.example.edukate.dtos.instructordto.InstructorDto;
import com.example.edukate.dtos.instructordto.InstructorUpdateDto;
import com.example.edukate.models.Instructor;
import com.example.edukate.models.Department;
import com.example.edukate.repositories.InstructorRepository;
import com.example.edukate.repositories.DepartmentRepository;
import com.example.edukate.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<InstructorDto> getInstructors() {
        return instructorRepository.findAll().stream()
                .filter(instructor -> !instructor.isDeleted())
                .map(instructor -> modelMapper.map(instructor, InstructorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDto instructorDetail(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return modelMapper.map(instructor, InstructorDto.class);
    }

    @Override
    public void addInstructor(InstructorCreateDto instructorCreateDto) {
//        Instructor instructor = modelMapper.map(instructorCreateDto, Instructor.class);
//
//        if (instructorCreateDto.getDepartmentId() != null) {
//            Department department = departmentRepository.findById(instructorCreateDto.getDepartmentId())
//                    .orElseThrow(() -> new RuntimeException("Department not found"));
//            instructor.setDepartment(department);
//        }
//
//        instructorRepository.save(instructor);
    }

    @Override
    public void updateInstructor(Long id, InstructorUpdateDto instructorUpdateDto) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        modelMapper.map(instructorUpdateDto, instructor);

        if (instructorUpdateDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(instructorUpdateDto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            instructor.setDepartment(department);
        }

        instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        instructor.setDeleted(true);
        instructorRepository.save(instructor);
    }
}
