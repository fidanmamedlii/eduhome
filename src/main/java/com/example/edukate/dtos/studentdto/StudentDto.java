package com.example.edukate.dtos.studentdto;

import com.example.edukate.dtos.departmentdto.DepartmentDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private DepartmentDto department;
}
