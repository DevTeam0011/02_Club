package com.club.Club.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.Club.DTO.ClaseCreateDTO;
import com.club.Club.DTO.EntrenadorDTO;
import com.club.Club.Entities.Clase;
import com.club.Club.Entities.Entrenador;
import com.club.Club.Services.EntrenadorServicio;

@RestController
@RequestMapping("/api/entrenador")
public class ControladorEntrenador {
    @Autowired
    EntrenadorServicio eServicio;

    // CREAR ENTRENADOR
    @PostMapping("")
    public void crearEntrenador(@RequestBody EntrenadorDTO EDTO) throws Exception {

        eServicio.CrearEntrenador(EDTO);
    }

    // LISTAR ENTRENADOR
    @GetMapping("")
    public List<Entrenador> listarEntrenador() {
        List<Entrenador> list = eServicio.listarEntrenador();
        return list;
    }

    // MODIFICAR ENTRENADOR
    @PutMapping("")
    public void modificarEntrenador(@RequestBody EntrenadorDTO EDTO) throws Exception {
        eServicio.modificarEntrenador(EDTO);
    }

    // TRAER ENTRENADOR POR ID
    @GetMapping("/clase_id/")
    public Entrenador traerClaseId(@RequestBody EntrenadorDTO EDTO) {
        return eServicio.getOne(EDTO);

    }

    // MODIFICAR ESTADO (DAR ALTA/DAR BAJA)
    @PutMapping("/modificar_estado")
    public void modificarEstadoEntrenador(@RequestBody EntrenadorDTO EDTO) {
        eServicio.modificarEstadoEntrenador(EDTO);

    }

}
