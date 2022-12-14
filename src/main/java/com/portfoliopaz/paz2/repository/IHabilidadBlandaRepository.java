package com.portfoliopaz.paz2.repository;

import com.portfoliopaz.paz2.entity.HabilidadBlanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadBlandaRepository extends JpaRepository <HabilidadBlanda, Integer>{    
}
