package com.example.lab_sem_3.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewArtistaDto {

    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;


}
