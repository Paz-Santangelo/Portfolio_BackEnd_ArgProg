package com.portfoliopaz.paz2.repository;

import com.portfoliopaz.paz2.entity.HabilidadDura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadDuraRepository extends JpaRepository <HabilidadDura, Integer>{
    
}
