package com.portfoliopaz.paz2.repository;

import com.portfoliopaz.paz2.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository <Experiencia, Integer>{
    
}
