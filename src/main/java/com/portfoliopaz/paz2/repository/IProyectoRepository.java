package com.portfoliopaz.paz2.repository;

import com.portfoliopaz.paz2.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository <Proyecto, Integer>{
    
}
