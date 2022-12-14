package com.portfoliopaz.paz2.service;

import com.portfoliopaz.paz2.entity.Proyecto;
import com.portfoliopaz.paz2.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    
    @Autowired
    IProyectoRepository proyectoRepository;
    
    public List<Proyecto> traerProyectos() {
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyecto> traerProyectoPorId(int id) {
        return proyectoRepository.findById(id);
    }
    
    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }
    
    public void eliminarProyecto(int id) {
        proyectoRepository.deleteById(id);
    }
    
}
