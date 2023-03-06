package br.com.alisonviana.entity

import jakarta.persistence.*

@Entity
@Table(name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(nullable = false)
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
)
