package com.example.edukate.dtos.coursedto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CourseDto {
    private String name;
    private int rating;
    private String image;
    private String instructorName;
}
