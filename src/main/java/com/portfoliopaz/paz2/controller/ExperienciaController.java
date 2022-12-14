package com.portfoliopaz.paz2.controller;

import com.portfoliopaz.paz2.dto.ExperienciaDto;
import com.portfoliopaz.paz2.entity.Experiencia;
import com.portfoliopaz.paz2.service.ExperienciaService;
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
@RequestMapping("/experiencia_laboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/list")
    @ResponseBody
    public List<Experiencia> getAllExperiencias() {
        return experienciaService.listaExperiencias();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Experiencia> getExperienciaById(@PathVariable("id") int id) {
        try {
            Experiencia experiencia = experienciaService.traerUnaExperiencia(id).get();
            return new ResponseEntity(experiencia, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> newExp(@RequestBody ExperienciaDto experienciaDto) {
        Experiencia experiencia = new Experiencia(experienciaDto.getImgExperiencia(), 
        experienciaDto.getPuesto(), experienciaDto.getAnio(), experienciaDto.getDescripcionTrabajo());
        
        experienciaService.guardarExperiencia(experiencia);
        
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateExp(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto) {
        try {

            Experiencia experiencia = experienciaService.traerUnaExperiencia(id).get();
            experiencia.setImgExperiencia(experienciaDto.getImgExperiencia());
            experiencia.setPuesto(experienciaDto.getPuesto());
            experiencia.setAnio(experienciaDto.getAnio());
            experiencia.setDescripcionTrabajo(experienciaDto.getDescripcionTrabajo());

            experienciaService.guardarExperiencia(experiencia);

            return new ResponseEntity<Experiencia>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Experiencia>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteExp(@PathVariable("id") int id) {
        experienciaService.eliminarExperiencia(id);
    }

}
