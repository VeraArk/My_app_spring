package org.example.my_javaproapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Teacher")
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // add OneToMany - students , Task

}
