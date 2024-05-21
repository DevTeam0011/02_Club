package com.club.Club.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.ActividadCreateDTO;
import com.club.Club.Entities.Actividad;
import com.club.Club.Others.metodosUtiles;
import com.club.Club.Repositories.ActividadRepositorio;

@Service
public class ActividadServicio {
    @Autowired
    ActividadRepositorio activRepositorio;

    //CREAR ACTIVIDAD
    @Transactional
    public void CrearActividad(ActividadCreateDTO ADTO) throws Exception {
        //VALIDAR ACTIVIVDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "descripcion", "horario", "costo" }, ADTO.getNombre(), ADTO.getDescripcion(),
                ADTO.getHorario(), ADTO.getCosto());

        Actividad newAct = new Actividad();
        newAct.setNombre(ADTO.getNombre());
        newAct.setDescripcion(ADTO.getDescripcion());
        newAct.setHorario(ADTO.getHorario());
        newAct.setCosto(ADTO.getCosto());
        activRepositorio.save(newAct);

    }



}
