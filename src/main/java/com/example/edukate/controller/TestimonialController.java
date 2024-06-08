package com.example.edukate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestimonialController {
    @GetMapping("/testimonial")
    public String index(){
        return "testimonial";
    }
}
