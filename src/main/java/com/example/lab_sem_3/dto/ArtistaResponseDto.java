package com.example.lab_sem_3.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArtistaResponseDto {

    private String username;

    private List<Long> cancionIdList = new ArrayList<>();
}
