package com.club.Club.Entities;

import java.time.LocalTime;

import com.club.Club.Enums.Turno;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private Long  id;

    private String nombre;

    @Temporal(TemporalType.TIME)
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @ManyToOne
    private Entrenador entrenador_id;

}
