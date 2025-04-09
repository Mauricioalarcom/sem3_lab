package com.example.lab_sem_3.artista;


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
    ResponseEntity<Artista> createArtista(@RequestBody Artista artista){
        return ResponseEntity.ok(artistaRepository.save(artista));
    }

    @GetMapping("/{id}")
    ResponseEntity<Artista> getArtista(@PathVariable Long id){
        Optional<Artista> artista = artistaRepository.findById(id);
        if (artista.isPresent()) {
            return ResponseEntity.ok(artista.get());
        }
        return ResponseEntity.notFound().build();
    }

}
