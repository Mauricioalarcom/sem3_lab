package com.example.lab_sem_3.Cancion;


import com.example.lab_sem_3.artista.Artista;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Integer duracion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cancion_artista",
            joinColumns = @JoinColumn(name = "cancion_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    private List<Artista> artistas = new ArrayList<>();
}
