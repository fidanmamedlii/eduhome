package com.example.edukate.dtos.testimonialdto;

import com.example.edukate.dtos.studentdto.StudentDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialDto {
    private Long id;
    private String content;
    private StudentDto student;
}
