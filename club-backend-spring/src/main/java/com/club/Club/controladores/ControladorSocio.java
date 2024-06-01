package com.club.Club.controladores;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.club.Club.DTO.SocioCreateDTO;
import com.club.Club.Entities.Socio;
import com.club.Club.Services.SocioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/socio")
public class ControladorSocio {

      @Autowired
    SocioServicio socioServicio;

    // CREAR CLASE
    @PostMapping("")
    public void crearClase(@RequestBody SocioCreateDTO SDTO) throws Exception {

        socioServicio.CrearSocio(SDTO);
    }

   // LISTAR CLASE
    @GetMapping("")
    public List<Socio> listarClases() {
        List<Socio> list = socioServicio.listarSocio();

        return list;
    }

  // TRAER ACTIVIDAD POR ID
  @GetMapping("/socio_id/")
  public Socio traersocioId(@PathVariable Long id) {
      return socioServicio.getOne(id);

  }

  // MODIFICAR ESTADO (DAR ALTA/DAR BAJA)
  @PutMapping("/modificar_estado")
  public void modificarEstadoActividad(@RequestBody SocioCreateDTO SDTO){
    socioServicio.modificarEstadoSocio(SDTO);

  }

}
 

   

    


    

