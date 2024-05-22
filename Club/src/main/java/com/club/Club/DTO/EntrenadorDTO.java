package com.club.Club.DTO;

import java.time.LocalTime;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class EntrenadorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private LocalTime horarioDisponibilidad;

}
