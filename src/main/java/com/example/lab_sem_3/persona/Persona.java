package com.example.lab_sem_3.persona;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", unique = false)
    private String nombre;

    @Column(name = "apellido", unique = false)
    private String apellido;

    @Column(name = "curso fav", unique = false)
    private String curso;
}


