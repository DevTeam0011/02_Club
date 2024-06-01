package com.club.Club.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.Club.Entities.Socio;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio,Long>{
    
    
}
