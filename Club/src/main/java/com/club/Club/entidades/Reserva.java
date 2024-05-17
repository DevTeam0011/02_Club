package com.club.Club.entidades;

import org.springframework.data.annotation.Id;

import com.club.Club.enums.Estados;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    
  /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; */

    private Socio socio;

    private Actividad actividad;

    @Temporal(TemporalType.TIME)
    private Data fecha_hora;

    @Enumerated(EnumType.STRING)
    private Estados estado;

}
