package com.club.Club.entidades;

import java.time.LocalDate;
import java.util.Date;

import org.aspectj.lang.annotation.SuppressAjWarnings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Socios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idSocio;
    private String nombre;
    private String apellido;
    private Integer documento;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;
    private Integer direccion;
    private Integer telefono;
    private boolean alta;
    
    //private Membresia membresia;
    
}
