package com.example.edukate.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="courses")
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CourseName")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image")
    private String image;

    @Column(name = "ApplyDescription")
    private String applyDescription;

    @Column(name = "CertificationDescription")
    private String certificationDescription;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "DurationTime")
    private String durationTime;

    @Column(name = "ClassDuration")
    private String classDuration;

    @Column(name = "SkillLevel")
    private String skillLevel;

    @Column(name = "Language")
    private String language;

    @Column(name = "StudentCapacity")
    private int studentCapacity;

    @Column(name = "Assessments")
    private String assessments;

    @Column(name = "Price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    private int rating;
}
