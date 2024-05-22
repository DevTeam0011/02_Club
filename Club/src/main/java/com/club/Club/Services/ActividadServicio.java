package com.club.Club.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotation.Adapt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.ActividadCreateDTO;
import com.club.Club.Entities.Actividad;
import com.club.Club.Others.metodosUtiles;
import com.club.Club.Repositories.ActividadRepositorio;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class ActividadServicio {
    @Autowired
    ActividadRepositorio activRepositorio;

    // CREAR ACTIVIDAD-----------------------------------------------
    @Transactional
    public void CrearActividad(ActividadCreateDTO ADTO) throws Exception {
        // VALIDAR ACTIVIVDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "descripcion", "horario", "costo" }, ADTO.getNombre(), ADTO.getDescripcion(),
                ADTO.getHorario(), ADTO.getCosto());

        Actividad newAct = new Actividad();
        newAct.setNombre(ADTO.getNombre());
        newAct.setDescripcion(ADTO.getDescripcion());
        newAct.setHorario(ADTO.getHorario());
        newAct.setCosto(ADTO.getCosto());
        newAct.setEstado(true);
        activRepositorio.save(newAct);

    }

    // LISTAR ACTIVIDADES-----------------------------------------------
    @Transactional(readOnly = true)
    public List<Actividad> listarActividades() {
        List<Actividad> actividades = new ArrayList();
        actividades = activRepositorio.findAll();
        return actividades;
    }

    // TRAER ACTIVIDAD POR ID-----------------------------------------------
    public Actividad getOne(ActividadCreateDTO ADTO) {
        Optional<Actividad> respuesta = activRepositorio.findById(ADTO.getId());
        if (respuesta.isPresent()) {
            Actividad newActividad = respuesta.get();
            return newActividad;
        }
        return null;
    }

    // MODIFICAR ACTIVIDAD-----------------------------------------------
    @Transactional
    public void modificarActividad(ActividadCreateDTO ADTO) throws Exception {
        // VALIDAR ACTIVIVDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "descripcion", "horario", "costo" }, ADTO.getNombre(), ADTO.getDescripcion(),
                ADTO.getHorario(), ADTO.getCosto());


        Optional<Actividad> actividad = activRepositorio.findById(ADTO.getId());

        if (actividad.isPresent()) {
            Actividad respuesta = actividad.get();
            respuesta.setNombre(ADTO.getNombre());
            respuesta.setDescripcion(ADTO.getDescripcion());
            respuesta.setHorario(ADTO.getHorario());
            respuesta.setCosto(ADTO.getCosto());
            activRepositorio.save(respuesta);
        }

    }


    //MODIFICAR ESTADO (DAR ALTA/DAR BAJA)-------------------------------
    @Transactional
    public void modificarEstadoActividad(ActividadCreateDTO ADTO){
       
        Optional<Actividad> actividad = activRepositorio.findById(ADTO.getId());

        if (actividad.isPresent()) {
            Actividad newActividad = actividad.get();

            if(newActividad.isEstado()){
                newActividad.setEstado(false);
            }else {
                 newActividad.setEstado(true);
            }
        }
    }

}
