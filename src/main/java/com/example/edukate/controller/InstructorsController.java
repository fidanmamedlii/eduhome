package com.example.edukate.controller;

import com.example.edukate.service.CourseService;
import com.example.edukate.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructorsController {
    private InstructorService service;
    private CourseService courseService;


    public InstructorsController(InstructorService service, CourseService courseService) {
        this.service = service;
        this.courseService = courseService;

    }

    @GetMapping("/team")
    public String index(Model model){
        var instructors=service.getInstructors();
        var courses=courseService.getCourses();
        model.addAttribute("instructors",instructors);
        model.addAttribute("courses",courses);
        return "instructors";
    }
}
