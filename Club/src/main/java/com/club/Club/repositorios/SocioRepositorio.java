package com.club.Club.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.Club.entidades.Socio;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio,Long>{
    
    
}
