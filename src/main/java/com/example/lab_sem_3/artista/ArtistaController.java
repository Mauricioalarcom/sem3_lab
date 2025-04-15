package com.example.lab_sem_3.artista;


import com.example.lab_sem_3.Exceptions.ResourceConflictException;
import com.example.lab_sem_3.Exceptions.ResourceInternalServerError;
import com.example.lab_sem_3.Exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    ArtistaRepository artistaRepository;



    @GetMapping
    ResponseEntity<List<Artista>> getAllArtistas(){
        List<Artista> artistas = artistaRepository.findAll();
        return ResponseEntity.ok(artistas);
    }

    @PostMapping
    ResponseEntity<Artista> createArtista(@Valid @RequestBody Artista artista){
        Optional<Artista> foundArtistaByUsername = artistaRepository.findByUsername(artista.getUsername());
        if(foundArtistaByUsername.isEmpty()){
            return ResponseEntity.ok(artistaRepository.save(artista));
        }
        throw new ResourceConflictException("El artista con username: " + artista.getUsername() + " ya existe.");
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Artista> getArtista(@PathVariable Long id){
        Optional<Artista> artista = artistaRepository.findById(id);
        if (artista.isPresent()) {
            return ResponseEntity.ok(artista.get());
        }
        throw new ResourceNotFoundException(("El artista con id: " + id + " no existe."));
    }

    @GetMapping("/nombre_cancion/{cancion}")
    ResponseEntity<Artista> getArtistaByCancion(@PathVariable String cancion){
        Optional<Artista> artista = artistaRepository.findByCancion(cancion);
        if (artista.isPresent()) {
            return ResponseEntity.ok(artista.get());
        }
        throw new ResourceInternalServerError("La cancion " + cancion + " no existe.");
    }

    @GetMapping
    ResponseEntity<Artista> getArtistaBySexo(@PathVariable String sexo){
        Optional<Artista> artista = artistaRepository.findBySexo(sexo);
        if (artista.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok(artista.get());
    }

}
