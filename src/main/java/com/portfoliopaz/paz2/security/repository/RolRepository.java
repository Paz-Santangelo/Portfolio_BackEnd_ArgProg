package com.portfoliopaz.paz2.security.repository;

import com.portfoliopaz.paz2.security.entity.Rol;
import com.portfoliopaz.paz2.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
