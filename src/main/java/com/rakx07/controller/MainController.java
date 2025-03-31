package com.rakx07.controller;

import com.rakx07.model.Student;
import com.rakx07.service.StudentService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/home")
    public String homePage() {
        return "home-page";
    }

    @PostMapping("/find-by-id")
    public ModelAndView findById(@RequestParam @Nullable Integer id, ModelAndView modelAndView, RedirectAttributes redirectAttributes){
        Student student = studentService.findById(id);
        if (student == null) {
            redirectAttributes.addFlashAttribute("error", "No student found");
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student-page");
        return modelAndView;
    }

    @GetMapping("/add-student")
    public String addStudent() {
        return "add-student-page.html";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "home-page";
    }

    @GetMapping("/list-all-student")
    public ModelAndView listAllStudent(ModelAndView modelAndView) {
        modelAndView.setViewName("all-student-page");
        modelAndView.addObject("studentList", studentService.getAllStudent());
        return modelAndView;
    }
}
