package com.portfoliopaz.paz2.service;

import com.portfoliopaz.paz2.entity.Experiencia;
import com.portfoliopaz.paz2.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    
    @Autowired
    IExperienciaRepository experienciaRepository;
    
    public List<Experiencia> listaExperiencias() {
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> traerUnaExperiencia(int id) {
        return experienciaRepository.findById(id);
    }
    
    public void guardarExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }
    
    public void eliminarExperiencia(int id) {
        experienciaRepository.deleteById(id);
    }
    
}
