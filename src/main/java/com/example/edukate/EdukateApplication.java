package com.example.edukate;

import com.example.edukate.dtos.coursedto.CourseCreateDto;
import com.example.edukate.service.impl.CourseServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdukateApplication {

    public static void main(String[] args) {
        var app = SpringApplication.run(EdukateApplication.class, args);
    }

}
