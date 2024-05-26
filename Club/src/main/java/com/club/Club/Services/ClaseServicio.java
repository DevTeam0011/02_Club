package com.club.Club.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.ClaseCreateDTO;
import com.club.Club.Entities.Clase;
import com.club.Club.Entities.Entrenador;
import com.club.Club.Others.metodosUtiles;
import com.club.Club.Repositories.ClaseRepositorio;
import com.club.Club.Repositories.EntrenadorRepositorio;

@Service
public class ClaseServicio {
    @Autowired
    ClaseRepositorio claseRepositorio;
    @Autowired
    EntrenadorRepositorio entrenadorRepositorio;

    // Crear una clase
    @Transactional
    public void crearClase(ClaseCreateDTO CDTO) throws Exception {
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "horario", "turno", "entrenador_id" }, CDTO.getNombre(),
                CDTO.getHorario(), CDTO.getTurno(), CDTO.getEntrenador_id());

        Clase newclase = new Clase();
        newclase.setNombre(CDTO.getNombre());
        newclase.setHorario(CDTO.getHorario());
        newclase.setTurno(CDTO.getTurno());

        Entrenador entrenador = entrenadorRepositorio.findById(CDTO.getEntrenador_id().getId())
                .orElseThrow(() -> new Exception("No se encontro entrenador con ese id"));

        newclase.setEntrenador_id(entrenador);
        claseRepositorio.save(newclase);

    }

    // LISTAR CLASES-----------------------------------------------------
    @Transactional(readOnly = true)
    public List<Clase> listarClases() {
        List<Clase> clase = new ArrayList<>();
        clase = claseRepositorio.findAll();
        return clase;
    }

    // TRAER SOCIOS POR ID-----------------------------------------------
    public Clase getOne(ClaseCreateDTO CDTO) {
        Optional<Clase> respuesta = claseRepositorio.findById(CDTO.getId());
        if (respuesta.isPresent()) {
            Clase newclase = respuesta.get();
            return newclase;
        }
        return null;
    }

    // MODIFICAR CLASE-----------------------------------------------
    @Transactional
    public void modificarClase(ClaseCreateDTO CDTO) throws Exception {

        // VALIDAR ACTIVIVDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "horario", "turno", "entrenador_id" }, CDTO.getNombre(),
                CDTO.getNombre(),
                CDTO.getHorario(), CDTO.getTurno(), CDTO.getEntrenador_id());

        Optional<Clase> clase = claseRepositorio.findById(CDTO.getId()); // claseRepositorio.findById(CDTO.getId());

        if (clase.isPresent()) {
            Clase respuesta = clase.get();
            respuesta.setNombre(CDTO.getNombre());
            respuesta.setHorario(CDTO.getHorario());
            respuesta.setTurno(CDTO.getTurno());
            respuesta.setEntrenador_id((CDTO.getEntrenador_id()));

            claseRepositorio.save(respuesta);
        }

    }

    @Transactional
    public void modificarEstadoClase(ClaseCreateDTO CDTO) {

        Optional<Clase> clase = claseRepositorio.findById(CDTO.getId());

        if (clase.isPresent()) {
            Clase newsocio = clase.get();

            /*
             * if(newclase.isAlta()){
             * newsocio.setAlta(false);
             * }else {
             * newsocio.setAlta(true);
             * }
             * }
             */

        }

    }
}
