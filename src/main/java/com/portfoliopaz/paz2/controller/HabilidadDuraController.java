package com.portfoliopaz.paz2.controller;

import com.portfoliopaz.paz2.dto.HabilidadDuraDto;
import com.portfoliopaz.paz2.entity.HabilidadDura;
import com.portfoliopaz.paz2.service.HabilidadDuraService;
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
@RequestMapping("/hards_skills")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadDuraController {

    @Autowired
    HabilidadDuraService habilidadService;

    @GetMapping("/list")
    @ResponseBody
    public List<HabilidadDura> getAllHabilidadesDuras() {
        return habilidadService.listaHabilidadesDuras();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<HabilidadDura> getHabilidadById(@PathVariable("id") int id) {
        try {
            HabilidadDura habilidadDura = habilidadService.traerHabilidadPorId(id).get();
            return new ResponseEntity(habilidadDura, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> newHabilidadDura(@RequestBody HabilidadDuraDto habilidadDto) {
        HabilidadDura habilidad = new HabilidadDura(habilidadDto.getPorcentaje(), habilidadDto.getNombre());
        habilidadService.guardarHabilidadDura(habilidad);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateHabilidadDura(@PathVariable("id") int id, @RequestBody HabilidadDuraDto habilidadDto) {
        try {
            HabilidadDura habilidadDura = habilidadService.traerHabilidadPorId(id).get();
            habilidadDura.setPorcentaje(habilidadDto.getPorcentaje());
            habilidadDura.setNombre(habilidadDto.getNombre());
            habilidadService.guardarHabilidadDura(habilidadDura);

            return new ResponseEntity<HabilidadDura>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<HabilidadDura>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteHabilidadDura(@PathVariable("id") int id) {
        habilidadService.eliminarHabilidadDura(id);
    }

}
