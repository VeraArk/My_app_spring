package org.example.my_javaproapp.repository;

import org.example.my_javaproapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
