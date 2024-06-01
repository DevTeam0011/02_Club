package com.club.Club.Entities;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String nombre;

    private String apellido;

    private Integer documento;

    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;

    private String direccion;

    private String telefono;
    
    private boolean alta;

    @ManyToMany @JoinTable(name ="socio_has_clase", 
    joinColumns = @JoinColumn(referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Clase> clase;

    @ManyToMany @JoinTable(name ="socio_has_actividad", 
    joinColumns = @JoinColumn(referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Actividad> actividad;


    
    //private Membresia membresia;
    
}
