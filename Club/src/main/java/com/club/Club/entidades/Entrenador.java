<<<<<<< HEAD
package com.Club.Club.entidades;
=======
package com.club.Club.entidades;
>>>>>>> 1dee2ae7e4a37af30349013746cf707da07769b5

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String apellido;
  private String especialidad;
  @Temporal(TemporalType.TIME)
  private LocalTime horarioDisponibilidad;
}
