package com.example.edukate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructorsController {
    @GetMapping("/team")
    public String index(){
        return "instructors";
    }
}
