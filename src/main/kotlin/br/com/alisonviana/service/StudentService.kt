package br.com.alisonviana.service

import br.com.alisonviana.entity.Student
import org.springframework.stereotype.Service

interface StudentService {
    fun getAllStudents(): List<Student>
    fun getStudentById(id: Long): Student
    fun saveStudent(student: Student): Student
    fun updateStudent(student: Student): Student
    fun deleteStudentById(id: Long)
}