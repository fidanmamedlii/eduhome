package com.example.edukate.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesController {
    @GetMapping("/courses")
    public String index(){
        return "courses";
    }
    @GetMapping("/courses/detail")
    public String detail(){
        return "courseDetails";
    }
}
