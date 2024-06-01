package com.club.Club.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.EntrenadorDTO;
import com.club.Club.Entities.Entrenador;
import com.club.Club.Others.metodosUtiles;
import com.club.Club.Repositories.EntrenadorRepositorio;

@Service
public class EntrenadorServicio {
    @Autowired
    EntrenadorRepositorio eRepositorio;

    @Transactional
    public void CrearEntrenador(EntrenadorDTO EDTO) throws Exception {
        // VALIDAR ACTIVIDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "apellido", "especialidad", "estado" },
                EDTO.getNombre(),
                EDTO.getApellido(),
                EDTO.getEspecialidad(),
                EDTO.isEstado());

        Entrenador newEntrenador = new Entrenador();
        newEntrenador.setNombre(EDTO.getNombre());
        newEntrenador.setApellido(EDTO.getApellido());
        newEntrenador.setEspecialidad(EDTO.getEspecialidad());
        newEntrenador.setEstado(EDTO.isEstado());

        eRepositorio.save(newEntrenador);
    }

    // LISTAR ACTIVIDADES-----------------------------------------------
    @Transactional(readOnly = true)
    public List<Entrenador> listarEntrenador() {
        List<Entrenador> entrenadores = new ArrayList<>();
        entrenadores = eRepositorio.findAll();
        return entrenadores;
    }

    // TRAER AENTRENADOR POR ID-----------------------------------------------
    public Entrenador getOne(Long id) {
        Optional<Entrenador> respuesta = eRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Entrenador newActividad = respuesta.get();
            return newActividad;
        }
        return null;
    }

    // MODIFICAR ENTRENADOR-----------------------------------------------
    @Transactional
    public void modificarEntrenador(EntrenadorDTO EDTO) throws Exception {
        // VALIDAR ACTIVIDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "apellido", "especialidad", "estado" },
                EDTO.getNombre(),
                EDTO.getApellido(),
                EDTO.getEspecialidad(),
                EDTO.isEstado());

        Optional<Entrenador> entrenador = eRepositorio.findById(EDTO.getId());

        if (entrenador.isPresent()) {
            Entrenador respuesta = entrenador.get();
            respuesta.setNombre(EDTO.getNombre());
            respuesta.setApellido(EDTO.getApellido());
            respuesta.setEspecialidad(EDTO.getEspecialidad());
            respuesta.setEstado(EDTO.isEstado());
            eRepositorio.save(respuesta);
        }

    }

    @Transactional
    public void modificarEstadoEntrenador(EntrenadorDTO EDTO) {

        Optional<Entrenador> entrenador = eRepositorio.findById(EDTO.getId());

        if (entrenador.isPresent()) {
            Entrenador newEntre = entrenador.get();

            if (newEntre.isEstado()) {
                newEntre.setEstado(false);
            } else {
                newEntre.setEstado(true);
            }
            eRepositorio.save(newEntre);
        }

    }
}
