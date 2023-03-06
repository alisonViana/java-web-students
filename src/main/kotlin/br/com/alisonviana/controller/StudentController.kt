package br.com.alisonviana.controller

import br.com.alisonviana.entity.Student
import br.com.alisonviana.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class StudentController(
    @Autowired
    var studentService: StudentService
) {

    @GetMapping("/students")
    fun students(model: Model): String {
        model.addAttribute("K_students", studentService.getAllStudents())

        return "students"
    }

    @GetMapping("/students/new")
    fun createStudentForm(model: Model): String {
        val student = Student()
        model.addAttribute("k_student", student)

        return "new_student"
    }

    @PostMapping("/student/new")
    fun saveStudent(@ModelAttribute("k_student") student: Student): String {
        studentService.saveStudent(student)

        return "redirect:/students"
    }

    @GetMapping("/students/edit")
    fun editStudentForm(@RequestParam id: Long, model: Model): String {
        model.addAttribute("k_student", studentService.getStudentById(id))

        return "edit_student"
    }

    @PostMapping("/students/edit")
    fun updateStudent(
        @RequestParam id: Long,
        @ModelAttribute("k_student") editedStudent: Student
    ): String {
        val student = studentService.getStudentById(id)

        student.firstName = editedStudent.firstName
        student.lastName = editedStudent.lastName
        student.email = editedStudent.email

        studentService.updateStudent(student)

        return "redirect:/students"
    }

    @GetMapping("/students/delete")
    fun deleteStudents(@RequestParam id: Long): String {
        studentService.deleteStudentById(id)

        return "redirect:/students"
    }

}