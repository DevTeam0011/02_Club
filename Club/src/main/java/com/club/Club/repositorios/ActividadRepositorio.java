package com.club.Club.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.club.Club.entidades.Actividad;

@Repository
public interface ActividadRepositorio extends JpaRepository<Actividad, Long> {
    
}
