package com.club.Club.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.Club.DTO.SocioCreateDTO;
import com.club.Club.Entities.Socio;
import com.club.Club.Others.metodosUtiles;
import com.club.Club.Repositories.SocioRepositorio;

@Service
public class SocioServicio {

    @Autowired
    SocioRepositorio socioRepositorio;

    @Transactional
    public void CrearSocio(SocioCreateDTO SDTO) throws Exception {
        // VALIDAR SOCIO-------------------------
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "apellido", "documento", "fecha_nacimiento", "direccion", "telefono", "alta" },
                SDTO.getNombre(), SDTO.getNombre(), SDTO.getApellido(),
                SDTO.getFecha_nacimiento(), SDTO.getDireccion(), SDTO.getDireccion());

        Socio newsocio = new Socio();
        newsocio.setNombre(SDTO.getNombre());
        newsocio.setApellido(SDTO.getApellido());
        newsocio.setDocumento(SDTO.getDocumento());
        newsocio.setFecha_nacimiento(SDTO.getFecha_nacimiento());
        newsocio.setDireccion(SDTO.getDireccion());
        newsocio.setTelefono(SDTO.getTelefono());
        newsocio.setAlta(false);

        socioRepositorio.save(newsocio);

    }

    // LISTAR SOCIO-----------------------------------------------
    @Transactional(readOnly = true)
    public List<Socio> listarSocio() {
        List<Socio> socios = new ArrayList<>();
        socios = socioRepositorio.findAll();
        return socios;
    }

    // TRAER SOCIOS POR ID-----------------------------------------------
    public Socio getOne(SocioCreateDTO SDTO) {
        Optional<Socio> respuesta = socioRepositorio.findById(SDTO.getId());
        if (respuesta.isPresent()) {
            Socio newsocio = respuesta.get();
            return newsocio;
        }
        return null;
    }
    // MODIFICAR SOCIO-----------------------------------------------

    @Transactional
    public void modificarsOCIO(SocioCreateDTO SDTO) throws Exception {

        // VALIDAR ACTIVIVDAD
        metodosUtiles.validateFieldsAreNotEmptyOrNull(
                new String[] { "nombre", "apellido", "fecha_nacimiento", "direccion", "telefono", "alta" },
                SDTO.getNombre(),
                SDTO.getApellido(),
                SDTO.getApellido(), SDTO.getFecha_nacimiento(), SDTO.getDireccion(), SDTO.getTelefono());

        Optional<Socio> socio = socioRepositorio.findById(SDTO.getId());

        if (socio.isPresent()) {
            Socio respuesta = socio.get();
            respuesta.setNombre(SDTO.getNombre());
            respuesta.setApellido(SDTO.getApellido());
            respuesta.setFecha_nacimiento(SDTO.getFecha_nacimiento());
            respuesta.setDireccion((SDTO.getDireccion()));
            respuesta.setTelefono(SDTO.getTelefono());
            respuesta.setAlta(false);
            socioRepositorio.save(respuesta);
        }

    }

    @Transactional
    public void modificarEstadoSocio(SocioCreateDTO SDTO) {

        Optional<Socio> socio = socioRepositorio.findById(SDTO.getId());

        if (socio.isPresent()) {
            Socio newsocio = socio.get();

            if (newsocio.isAlta()) {
                newsocio.setAlta(false);
            } else {
                newsocio.setAlta(true);
            }
        }

    }

}
