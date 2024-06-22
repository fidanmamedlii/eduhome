package com.example.edukate.dtos.testimonialdto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialCreateDto {
    private String content;
    private Long studentId;
}
