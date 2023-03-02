package br.com.alisonviana.controller;

import br.com.alisonviana.entity.Student;
import br.com.alisonviana.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/students/new")
    public String saveStudent(@ModelAttribute("k_student") Student student) {
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit")
    public String editStudentForm(@RequestParam Long id, Model model) {
        model.addAttribute("k_student", studentService.getStudentById(id));

        return "edit_student";
    }

    @PostMapping("/students/edit")
    public String updateStudent(@RequestParam Long id,
                                @ModelAttribute("k_student") Student editedStudent) {

        Student student = studentService.getStudentById(id);

        student.setFirstName(editedStudent.getFirstName());
        student.setLastName(editedStudent.getLastName());
        student.setEmail(editedStudent.getEmail());

        studentService.updateStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/delete")
    public String deleteStudents(@RequestParam Long id) {
        studentService.deleteStudentById(id);

        return "redirect:/students";
    }
}
