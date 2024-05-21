package com.club.Club.DTO;

import lombok.Data;

@Data
public class ActividadCreateDTO {
    private Long id;

    private String nombre;

    private String descripcion;

    private String horario;

    private Integer costo;
}
