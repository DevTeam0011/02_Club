package com.club.Club.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.Club.DTO.ActividadCreateDTO;
import com.club.Club.Entities.Actividad;
import com.club.Club.Services.ActividadServicio;

@RestController
@RequestMapping("/api/actividad")
public class ControladorActividad {

   @Autowired
   ActividadServicio actividadServicio;
   
   // LISTAR ACTIVIDAD
    @GetMapping("")
    public List<Actividad> listarActividades(){
        List<Actividad> list = actividadServicio.listarActividades();

          return list;
    }

     // CREAR ACTIVIDAD

     @PostMapping("")
     public void crearActividad(@RequestBody ActividadCreateDTO ADTO)throws Exception{
        
        actividadServicio.CrearActividad(ADTO);
     }
     // TRAER ACTIVIDAD POR ID
     @GetMapping("/actividad_id/")
     public Actividad traerActividadId(@RequestBody ActividadCreateDTO ADTO ){
        //actividadServicio.getOne(ADTO);
        return actividadServicio.getOne(ADTO);

     }
     // MODIFICAR ACTIVIDAD
     @PutMapping("")
     public void modificarActividad(@RequestBody ActividadCreateDTO ADTO)throws Exception{
        actividadServicio.modificarActividad(ADTO);


     }
     // MODIFICAR ESTADO (DAR ALTA/DAR BAJA)
     @PutMapping("/modificar_estado")
     public void modificarEstadoActividad(@RequestBody ActividadCreateDTO ADTO){
        actividadServicio.modificarEstadoActividad(ADTO);

     }
    
}
