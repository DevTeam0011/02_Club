package com.club.Club.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.club.Club.Entities.Actividad;

@Repository
public interface ActividadRepositorio extends JpaRepository<Actividad, Long> {

    @Query(value = "SELECT * FROM Actividad WHERER entrenador_id = :entrenador_id ", nativeQuery = true)
    Optional<Actividad> findByEntrnador_idl(Boolean entrenador_id);
    
}
