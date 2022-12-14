package com.portfoliopaz.paz2.controller;

import com.portfoliopaz.paz2.dto.PersonaDto;
import com.portfoliopaz.paz2.entity.Persona;
import com.portfoliopaz.paz2.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/details")
    @ResponseBody
    public List<Persona> getPersonas() {
        return personaService.traerPersonas();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") int id) {
        try {
            Persona persona = personaService.traerPersona(id).get();
            return new ResponseEntity(persona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable("id") int id, @RequestBody PersonaDto personaDto) {
        try {
            Persona persona = personaService.traerPersona(id).get();
            persona.setImgPerfil(personaDto.getImgPerfil());
            persona.setNombreCompleto(personaDto.getNombreCompleto());
            persona.setTitulo(personaDto.getTitulo());
            persona.setAcerca(personaDto.getAcerca());

            personaService.guardarPersona(persona);

            return new ResponseEntity<Persona>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void newPersona(@RequestBody Persona persona) {
        personaService.guardarPersona(persona);
    }

}
