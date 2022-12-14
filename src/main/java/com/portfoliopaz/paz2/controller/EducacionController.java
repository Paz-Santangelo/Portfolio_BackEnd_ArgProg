package com.portfoliopaz.paz2.controller;

import com.portfoliopaz.paz2.dto.EducacionDto;
import com.portfoliopaz.paz2.entity.Educacion;
import com.portfoliopaz.paz2.service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/list")
    @ResponseBody
    public List<Educacion> getAllEducaciones() {
        return educacionService.listaEducacion();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Educacion> getEducationById(@PathVariable("id") int id) {
        try {
            Educacion educacion = educacionService.traerEducacionPorId(id).get();
            return new ResponseEntity(educacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> newEducation(@RequestBody EducacionDto educacionDto) {
       
        Educacion educacion = new Educacion(educacionDto.getImgCurso(), educacionDto.getTituloCurso(),
        educacionDto.getAnio(), educacionDto.getDescripcionCurso());
        
        educacionService.guardarEducacion(educacion);
        
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable("id") int id, @RequestBody EducacionDto educacionDto) {

        try {
            Educacion educacion = educacionService.traerEducacionPorId(id).get();
            educacion.setImgCurso(educacionDto.getImgCurso());
            educacion.setTituloCurso(educacionDto.getTituloCurso());
            educacion.setAnio(educacionDto.getAnio());
            educacion.setDescripcionCurso(educacionDto.getDescripcionCurso());

            educacionService.guardarEducacion(educacion);

            return new ResponseEntity<Educacion>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Educacion>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteEducation(@PathVariable("id") int id) {
        educacionService.eliminarEducacion(id);
    }

}
