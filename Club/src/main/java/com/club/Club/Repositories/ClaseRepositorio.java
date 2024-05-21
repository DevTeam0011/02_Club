package com.club.Club.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.Club.Entities.Clase;
@Repository
public interface ClaseRepositorio  extends JpaRepository<Clase,Long>{
    
}
