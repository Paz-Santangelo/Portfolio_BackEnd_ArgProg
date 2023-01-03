package com.portfoliopaz.paz2.controller;

import com.portfoliopaz.paz2.dto.ProyectoDto;
import com.portfoliopaz.paz2.entity.Proyecto;
import com.portfoliopaz.paz2.service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyectos")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-paz.web.app")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/list")
    @ResponseBody
    public List<Proyecto> getAllProyectos() {
        return proyectoService.traerProyectos();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable("id") int id) {
        try {
            Proyecto proyecto = proyectoService.traerProyectoPorId(id).get();
            return new ResponseEntity(proyecto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> newProyecto(@RequestBody ProyectoDto proyectoDto) {
        Proyecto proyecto = new Proyecto(proyectoDto.getImgProyecto(), proyectoDto.getNombreProyecto(),
        proyectoDto.getDescripcionProyecto(), proyectoDto.getLinkProyecto());
        
        proyectoService.guardarProyecto(proyecto);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateProyecto(@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto) {
        try {
            Proyecto proyecto = proyectoService.traerProyectoPorId(id).get();
            proyecto.setImgProyecto(proyectoDto.getImgProyecto());
            proyecto.setNombreProyecto(proyectoDto.getNombreProyecto());
            proyecto.setDescripcionProyecto(proyectoDto.getDescripcionProyecto());
            proyecto.setLinkProyecto(proyectoDto.getLinkProyecto());
            
            proyectoService.guardarProyecto(proyecto);
            
            return new ResponseEntity<Proyecto>(HttpStatus.OK);            
        } catch (Exception e) {
            return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteProyecto(@PathVariable("id") int id) {
        proyectoService.eliminarProyecto(id);
    }

}
