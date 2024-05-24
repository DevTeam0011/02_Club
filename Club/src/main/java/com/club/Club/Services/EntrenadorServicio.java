package com.club.Club.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.EntrenadorDTO;
import com.club.Club.Entities.Entrenador;
import com.club.Club.Repositories.EntrenadorRepositorio;

@Service
public class EntrenadorServicio {
    @Autowired
    EntrenadorRepositorio entrenadorRepositorio;

    // @Transactional
    // public void CrearEntrenador(EntrenadorDTO EDTO) throws Exception {
        // // VALIDAR ACTIVIVDAD
        // metodosUtiles.validateFieldsAreNotEmptyOrNull(
        //  new String[] { "nombre", "apellido", "especialidad", "horarioDisponibilidad"}, EDTO.getNombre(),
        //  EDTO.getApellido(),EDTO.getEspecialidad(), EDTO.getHorarioDisponibilidad());

        // Entrenador newEntre = new Entrenador();
        // newEntre.setNombre(EDTO.getNombre());
        // newEntre.setApellido(EDTO.getApellido());
        // newEntre.setEspecialidad(EDTO.getEspecialidad());
        // newEntre.setHorarioDisponibilidad(EDTO.getHorarioDisponibilidad());

    // // EntrenadorRepositorio.save(newEntre);

    // }

    // LISTAR ACTIVIDADES-----------------------------------------------
    @Transactional(readOnly = true)
    public List<Entrenador> listarActividades() {
        List<Entrenador> entrenadores = new ArrayList<>();
        entrenadores = entrenadorRepositorio.findAll();
        return entrenadores;
    }

    // TRAER AENTRENADOR POR ID-----------------------------------------------
    public Entrenador getOne(EntrenadorDTO EDTO) {
        Optional<Entrenador> respuesta = entrenadorRepositorio.findById(EDTO.getId());
        if (respuesta.isPresent()) {
            Entrenador newActividad = respuesta.get();
            return newActividad;
        }
        return null;
    }

    // MODIFICAR ENTRENADOR-----------------------------------------------
    // @Transactional
    // public void modificarEntrenador(EntrenadorDTO EDTO) throws Exception {
    // // VALIDAR ACTIVIVDAD
    // metodosUtiles.validateFieldsAreNotEmptyOrNull(
    // new String[] { "nombre", "apellido", "especialidad", "horarioDisponibilidad"
    // }, EDTO.getNombre(),
    // EDTO.getApellido(),
    // EDTO.getEspecialidad(), EDTO.getHorarioDisponibilidad());

    // Optional<Entrenador> entrenador =
    // entrenadorRepositorio.findById(EDTO.getId());

    // if (entrenador.isPresent()) {
    // Entrenador respuesta = entrenador.get();
    // respuesta.setNombre(EDTO.getNombre());
    // respuesta.setApellido(EDTO.getApellido());
    // respuesta.setEspecialidad(EDTO.getEspecialidad());
    // respuesta.setHorarioDisponibilidad(EDTO.getHorarioDisponibilidad());
    // entrenadorRepositorio.save(respuesta);
    // }

    // }

    @Transactional
    public void modificarEstadoActividad(EntrenadorDTO EDTO) {

        Optional<Entrenador> entrenador = entrenadorRepositorio.findById(EDTO.getId());

        if (entrenador.isPresent()) {
            Entrenador newEntre = entrenador.get();

            /*
             * if(newEntre.isEstado()){
             * newEntre.setEstado(false);
             * }else {
             * newActividad.setEstado(true);
             * }
             * }
             */
        }

    }
}
