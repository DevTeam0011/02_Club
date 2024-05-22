package com.club.Club.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.ClaseCreateDTO;
import com.club.Club.Others.metodosUtiles;
import com.club.Club.Repositories.ClaseRepositorio;

@Service
public class ClaseServicio {
    @Autowired
    ClaseRepositorio claseRepositorio;

    //Crear una clase
    @Transactional
    public void crearClase(ClaseCreateDTO createDTO) throws Exception{
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre_clase", "descripcion", "horario", "entrenador" }, createDTO.getNombre_clase(), createDTO.getDescripcion(), createDTO.getHorario(), createDTO.getHorario(), createDTO.getEntrenador());

        

    }
}
