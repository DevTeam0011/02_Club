package com.club.club.entidades;

import org.springframework.data.annotation.Id;

import com.club.club.enums.Estados;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Socio socio;

    private Actividad actividad;

    @Temporal(TemporalType.TIME)
    private Data fecha_hora;

    @Enumerated(EnumType.STRING)
    private Estados estado;

}
