package com.example.lab_sem_3.artista;


import com.example.lab_sem_3.Cancion.Cancion;
import com.example.lab_sem_3.persona.Persona;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String cancion;

    @Column(unique = false)
    private String sexo;

    @ManyToMany(mappedBy = "artistas")
    private List<Cancion> canciones;

}
