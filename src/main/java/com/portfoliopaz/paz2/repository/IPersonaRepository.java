package com.portfoliopaz.paz2.repository;

import com.portfoliopaz.paz2.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Integer>{    
}
