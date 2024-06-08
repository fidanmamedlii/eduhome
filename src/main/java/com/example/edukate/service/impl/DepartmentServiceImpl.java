package com.example.edukate.service.impl;

import com.example.edukate.dtos.departmentdto.DepartmentCreateDto;
import com.example.edukate.dtos.departmentdto.DepartmentDto;
import com.example.edukate.dtos.departmentdto.DepartmentUpdateDto;
import com.example.edukate.models.Department;
import com.example.edukate.repositories.DepartmentRepository;
import com.example.edukate.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll().stream()
                .filter(department -> !department.isDeleted())
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto departmentDetail(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public void addDepartment(DepartmentCreateDto departmentCreateDto) {
        Department department = modelMapper.map(departmentCreateDto, Department.class);
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Long id, DepartmentUpdateDto departmentUpdateDto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        modelMapper.map(departmentUpdateDto, department);
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        department.setDeleted(true);
        departmentRepository.save(department);
    }
}
