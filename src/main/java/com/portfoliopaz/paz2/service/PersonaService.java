package com.portfoliopaz.paz2.service;

import com.portfoliopaz.paz2.entity.Persona;
import com.portfoliopaz.paz2.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    private IPersonaRepository persoRepository;

    public List<Persona> traerPersonas() {
        return persoRepository.findAll();
    }

    public Optional<Persona> traerPersona(int id) {
        return persoRepository.findById(id);
    }

    public void guardarPersona(Persona persona) {
        persoRepository.save(persona);
    }
    
}
