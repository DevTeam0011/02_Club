package com.club.Club.DTO;
import java.time.LocalDate;

import com.club.Club.Entities.Entrenador;

import lombok.Data;

@Data
public class ClaseCreateDTO {

    private Long  idClase;

    private String nombre_clase;

    private String descripcion;

    private LocalDate horario;

    private Entrenador entrenador;
}
