package com.example.edukate.controller.Admin;

import com.example.edukate.models.Course;
import com.example.edukate.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@Controller
@RequestMapping("/admin/courses")
public class CoursesAdminController {

    private final CourseRepository courseRepository;

    @Autowired
    public CoursesAdminController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "dashboard/course/courses";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "dashboard/course/course-create";
    }

    @PostMapping("/create")
    public String createCourse(@ModelAttribute("course") Course course) {
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + id));
        model.addAttribute("course", course);
        return "dashboard/course/update";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/remove/{id}")
    public String courseRemove(@PathVariable Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + id));
        course.setDeleted(true);
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/activate/{id}")
    public String activateCourse(@PathVariable Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + id));
        course.setDeleted(false);
        courseRepository.save(course);
        return "redirect:/admin/courses";
    }
}
