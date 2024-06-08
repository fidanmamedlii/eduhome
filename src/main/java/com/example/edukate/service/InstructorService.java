package com.example.edukate.service;

import com.example.edukate.dtos.instructordto.InstructorCreateDto;
import com.example.edukate.dtos.instructordto.InstructorDto;
import com.example.edukate.dtos.instructordto.InstructorUpdateDto;

import java.util.List;

public interface InstructorService {
    List<InstructorDto> getInstructors();
    InstructorDto instructorDetail(Long id);
    void addInstructor(InstructorCreateDto instructorCreateDto);
    void updateInstructor(Long id, InstructorUpdateDto instructorUpdateDto);
    void deleteInstructor(Long id);
}
