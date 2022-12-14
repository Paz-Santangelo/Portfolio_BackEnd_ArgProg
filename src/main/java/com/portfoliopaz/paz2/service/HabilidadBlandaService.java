package com.portfoliopaz.paz2.service;

import com.portfoliopaz.paz2.entity.HabilidadBlanda;
import com.portfoliopaz.paz2.repository.IHabilidadBlandaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadBlandaService {
    
    @Autowired
    IHabilidadBlandaRepository habilidadRepository;
    
    public List<HabilidadBlanda> traerHabilidadesBlandas() {
        return habilidadRepository.findAll();
    }
    
    public Optional<HabilidadBlanda> traerHabilidadPorId (int id) {
        return habilidadRepository.findById(id);
    }
    
    public void guardarHabilidadBlanda (HabilidadBlanda habilidad) {
        habilidadRepository.save(habilidad);
    }
    
    public void eliminarHabilidadBlanda (int id) {
        habilidadRepository.deleteById(id);
    }
}
