package com.example.edukate.controller;

import com.example.edukate.service.CourseService;
import com.example.edukate.service.TestimonialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestimonialController {


    private TestimonialService service;
    private CourseService courseService;
    public TestimonialController(TestimonialService service, CourseService courseService) {
        this.service = service;
        this.courseService = courseService;
    }

    @GetMapping("/testimonial")
    public String index(Model model){
        var testimonials=service.getTestimonials();
        var courses=courseService.getCourses();
        model.addAttribute("testimonials",testimonials);
        model.addAttribute("courses",courses);

        return "testimonial";
    }
}
