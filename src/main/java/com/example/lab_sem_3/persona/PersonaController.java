package com.example.lab_sem_3.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping
    ResponseEntity<List<Persona>> getPersona(){
        return ResponseEntity.ok(personaRepository.findAll());
    }

    @PostMapping
    ResponseEntity<Persona> create(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaRepository.save(persona));
    }

    @GetMapping("/{id}")
    ResponseEntity<Persona> getPersona(@PathVariable Long id){
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona.get());
    }

    @GetMapping("/nombre/{nombre}")
    ResponseEntity<List<Persona>> getPersonaByNombre(@PathVariable String nombre){
        List<Persona> personas = personaRepository.findByNombre(nombre);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/apellido/{apellido}")
    ResponseEntity<List<Persona>> getPersonaByApellido(@PathVariable String apellido){
        List<Persona> personas = personaRepository.findByApellido(apellido);
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/curso_fav/{curso}")
    ResponseEntity<List<Persona>> getPersonaByCurso(@PathVariable String curso){
        List<Persona> personas = personaRepository.findByCurso(curso);
        return ResponseEntity.ok(personas);
    }
}
