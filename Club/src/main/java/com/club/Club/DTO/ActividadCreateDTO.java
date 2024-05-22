package com.club.Club.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class ActividadCreateDTO {
    private Long id;

    private String nombre;

    private String descripcion;

    private Date horario;

    private Integer costo;
}
