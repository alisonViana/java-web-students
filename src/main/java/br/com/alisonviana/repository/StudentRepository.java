package br.com.alisonviana.repository;

import br.com.alisonviana.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Não está sendo monitorado com @Repository
// JpaRepository já possui a anotação @Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
