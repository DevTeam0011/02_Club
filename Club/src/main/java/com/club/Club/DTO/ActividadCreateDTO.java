package com.club.Club.DTO;

import com.club.Club.Entities.Entrenador;

import lombok.Data;

@Data
public class ActividadCreateDTO {
    private Long id;

    private String nombre;

    private String descripcion;

    private Double costo;

    private boolean estado;

    private Entrenador entrenador_id;
}
