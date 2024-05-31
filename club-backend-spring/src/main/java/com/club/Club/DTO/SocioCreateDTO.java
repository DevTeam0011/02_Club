package com.club.Club.DTO;

import java.time.LocalDate;
import java.util.List;

import com.club.Club.Entities.Actividad;
import com.club.Club.Entities.Clase;

import lombok.Data;

@Data
public class SocioCreateDTO {
    private Long id;

    private String nombre;

    private String apellido;

    private Integer documento;

    private LocalDate fecha_nacimiento;

    private String direccion;

    private String telefono;

    private boolean alta;

    private List<Clase> clase;

    private List<Actividad> actividad;
}
