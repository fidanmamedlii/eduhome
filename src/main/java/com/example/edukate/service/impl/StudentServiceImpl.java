package com.example.edukate.service.impl;

import com.example.edukate.dtos.studentdto.StudentCreateDto;
import com.example.edukate.dtos.studentdto.StudentDto;
import com.example.edukate.dtos.studentdto.StudentUpdateDto;
import com.example.edukate.models.Department;
import com.example.edukate.models.Student;
import com.example.edukate.repositories.DepartmentRepository;
import com.example.edukate.repositories.StudentRepository;
import com.example.edukate.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> getStudents() {
        return studentRepository.findAll().stream()
                .filter(student -> !student.isDeleted())
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto studentDetail(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void addStudent(StudentCreateDto studentCreateDto) {
        Student student = modelMapper.map(studentCreateDto, Student.class);

        if (studentCreateDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(studentCreateDto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            student.setDepartment(department);
        }

        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, StudentUpdateDto studentUpdateDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        modelMapper.map(studentUpdateDto, student);

        if (studentUpdateDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(studentUpdateDto.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            student.setDepartment(department);
        }

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setDeleted(true);
        studentRepository.save(student);
    }
}
