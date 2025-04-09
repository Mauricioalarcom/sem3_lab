package com.example.lab_sem_3.persona;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findByNombre(String nombre);
    List<Persona> findByApellido(String apellido);
    List<Persona> findByCurso(String curso);
}
