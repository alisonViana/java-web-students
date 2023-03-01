package br.com.alisonviana.controller;

import br.com.alisonviana.entity.Student;
import br.com.alisonviana.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("k_students", studentService.getAllStudents());

        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("k_student", student);

        return "new_student";
    }

    @PostMapping("/new_student")
    public String saveStudent(@ModelAttribute("k_student") Student student) {
        studentService.saveStudent(student);

        return "redirect:/students";
    }
}
