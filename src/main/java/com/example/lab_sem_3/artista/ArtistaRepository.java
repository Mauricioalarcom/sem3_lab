package com.example.lab_sem_3.artista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByUsername(String username);
    Optional<Artista> findByCancion(String cancion);
    Optional<Artista> findBySexo(String sexo);
}
