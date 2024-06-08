//package com.example.edukate.dtos.coursedto;
//
//public class CourseCreateDto {
//    private String name;
//    private Long instructorId;
//
//    private int rating;
//
//
//
//}
package com.example.edukate.dtos.coursedto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CourseCreateDto {
    private String name;
    private String description;
    private String image;
    private String applyDescription;
    private String certificationDescription;
    private Date startDate;
    private String durationTime;
    private String classDuration;
    private String skillLevel;
    private String language;
    private int studentCapacity;
    private String assessments;
    private double price;
    private Long instructorId;
}