package br.com.alisonviana.service.impl

import br.com.alisonviana.entity.Student
import br.com.alisonviana.repository.StudentRepository
import br.com.alisonviana.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(
    @Autowired
    var studentRepository: StudentRepository
): StudentService {
    override fun getAllStudents(): List<Student> =
        studentRepository.findAll()

    override fun getStudentById(id: Long): Student =
        studentRepository.findById(id).get()

    override fun saveStudent(student: Student): Student =
        studentRepository.save(student)

    override fun updateStudent(student: Student): Student =
        studentRepository.save(student)

    override fun deleteStudentById(id: Long) =
        studentRepository.deleteById(id)
}