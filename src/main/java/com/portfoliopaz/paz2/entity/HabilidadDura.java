package com.portfoliopaz.paz2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class HabilidadDura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int porcentaje;
    private String nombre;

    public HabilidadDura() {
    }

    public HabilidadDura(int porcentaje, String nombre) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }
  
}
