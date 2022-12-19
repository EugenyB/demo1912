package com.example.demo1912.controllers;

import com.example.demo1912.data.Teacher;
import com.example.demo1912.repositories.SubjectRepository;
import com.example.demo1912.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private TeacherRepository teacherRepository;

    private SubjectRepository subjectRepository;

    @GetMapping("/teachers")
    public String showTeachers(Model model) {
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/teacher_subjects/{id}")
    public String subjectsByTeacher(@PathVariable("id") long id, Model model) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isEmpty()) {
            return "redirect:/teachers";
        } else {
            model.addAttribute("teacher", teacher.get());
            model.addAttribute("allsubjects", subjectRepository.findAll());
            return "subjects_by_teacher";
        }
    }
}
