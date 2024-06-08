package com.example.edukate.dtos.studentdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreateDto {
    private String name;
    private String surname;
    private Long departmentId;
}
