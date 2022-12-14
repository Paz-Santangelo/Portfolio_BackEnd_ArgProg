package com.portfoliopaz.paz2.service;

import com.portfoliopaz.paz2.entity.HabilidadDura;
import com.portfoliopaz.paz2.repository.IHabilidadDuraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadDuraService {
    
    @Autowired
    IHabilidadDuraRepository habilidadDuraRepository;
    
    public List<HabilidadDura> listaHabilidadesDuras() {
        return habilidadDuraRepository.findAll();
    }
    
    public Optional<HabilidadDura> traerHabilidadPorId(int id) {
        return habilidadDuraRepository.findById(id);
    }
    
    public void guardarHabilidadDura (HabilidadDura habilidad){
        habilidadDuraRepository.save(habilidad);
    }
    
    public void eliminarHabilidadDura (int id) {
        habilidadDuraRepository.deleteById(id);
    }
}
