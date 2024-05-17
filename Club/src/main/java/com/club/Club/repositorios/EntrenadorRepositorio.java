package com.club.Club.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.Club.entidades.Entrenador;

@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador,Long> {

    
}
