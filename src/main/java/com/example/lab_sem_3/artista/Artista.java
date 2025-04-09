package com.example.lab_sem_3.artista;


import com.example.lab_sem_3.persona.Persona;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "persona_id")
    @JsonBackReference
    private Persona persona;
}
