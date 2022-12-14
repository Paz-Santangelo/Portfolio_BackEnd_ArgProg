package com.portfoliopaz.paz2.repository;

import com.portfoliopaz.paz2.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository <Educacion, Integer>{
    
}
