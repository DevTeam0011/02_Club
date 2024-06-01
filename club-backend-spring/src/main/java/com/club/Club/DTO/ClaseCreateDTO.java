package com.club.Club.DTO;

import java.time.LocalTime;

import com.club.Club.Entities.Entrenador;
import com.club.Club.Enums.Turno;

import lombok.Data;

@Data
public class ClaseCreateDTO {

    private Long  id;

    private String nombre;

    private LocalTime horario;

    private Turno turno;

    private Entrenador entrenador_id;
}
