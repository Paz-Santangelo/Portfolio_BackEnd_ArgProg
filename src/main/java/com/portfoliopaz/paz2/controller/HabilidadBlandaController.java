package com.portfoliopaz.paz2.controller;

import com.portfoliopaz.paz2.dto.HabilidadBlandaDto;
import com.portfoliopaz.paz2.entity.HabilidadBlanda;
import com.portfoliopaz.paz2.service.HabilidadBlandaService;
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
@RequestMapping("/soft_skills")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-paz.web.app")
public class HabilidadBlandaController {

    @Autowired
    HabilidadBlandaService habilidadService;

    @GetMapping("/list")
    @ResponseBody
    public List<HabilidadBlanda> getAllHabilidadesBlandas() {
        return habilidadService.traerHabilidadesBlandas();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<HabilidadBlanda> getHabilidadById(@PathVariable("id") int id) {
        try {
            HabilidadBlanda habilidadBlanda = habilidadService.traerHabilidadPorId(id).get();
            return new ResponseEntity(habilidadBlanda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> newHabilidadBlanda(@RequestBody HabilidadBlandaDto habilidadDto) {
        HabilidadBlanda habilidad = new HabilidadBlanda(habilidadDto.getPorcentaje(), habilidadDto.getNombre());
        habilidadService.guardarHabilidadBlanda(habilidad);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateHabilidadBlanda(@PathVariable("id") int id, @RequestBody HabilidadBlandaDto habilidadDto
    ) {
        try {
            HabilidadBlanda habilidadBlanda = habilidadService.traerHabilidadPorId(id).get();
            habilidadBlanda.setPorcentaje(habilidadDto.getPorcentaje());
            habilidadBlanda.setNombre(habilidadDto.getNombre());

            habilidadService.guardarHabilidadBlanda(habilidadBlanda);

            return new ResponseEntity<HabilidadBlanda>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<HabilidadBlanda>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteHabilidadBlanda(@PathVariable("id") int id
    ) {
        habilidadService.eliminarHabilidadBlanda(id);
    }

}
