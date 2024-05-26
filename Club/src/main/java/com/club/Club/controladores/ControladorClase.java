package com.club.Club.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.Club.DTO.ClaseCreateDTO;
import com.club.Club.Entities.Clase;
import com.club.Club.Services.ClaseServicio;

@RestController
@RequestMapping("/api/clase")
public class ControladorClase {
    @Autowired
    ClaseServicio claseServicio;

    // CREAR CLASE
    @PostMapping("")
    public void crearClase(@RequestBody ClaseCreateDTO CDTO) throws Exception {

        claseServicio.crearClase(CDTO);
    }

    // LISTAR CLASE
    @GetMapping("")
    public List<Clase> listarClases() {
        List<Clase> list = claseServicio.listarClases();

        return list;
    }

    // MODIFICAR CLASE
    @PutMapping("")
    public void modificarClase(@RequestBody ClaseCreateDTO CDTO) throws Exception {
        claseServicio.modificarClase(CDTO);
    }

    // TRAER ACTIVIDAD POR ID
    @GetMapping("/clase_id/")
    public Clase traerClaseId(@RequestBody ClaseCreateDTO CDTO) {
        return claseServicio.getOne(CDTO);

    }

    // MODIFICAR ESTADO (DAR ALTA/DAR BAJA)
    @PutMapping("/modificar_estado")
    public void modificarEstadoActividad(@RequestBody ClaseCreateDTO CDTO){
     claseServicio.modificarEstadoClase(CDTO);

    }

}
