package com.club.Club.entidades;
<<<<<<< HEAD

import java.time.LocalDate;

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
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String  idClase;
    private String nombre_clase;
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private LocalDate horario;
    private String entrenador;

    
}
=======
>>>>>>> 1dee2ae7e4a37af30349013746cf707da07769b5
