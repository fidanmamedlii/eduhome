package com.example.edukate.dtos.studentdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDto {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
}
