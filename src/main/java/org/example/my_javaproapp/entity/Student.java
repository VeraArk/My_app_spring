package org.example.my_javaproapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")

@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
