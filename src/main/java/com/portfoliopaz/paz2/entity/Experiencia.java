package com.portfoliopaz.paz2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgExperiencia;
    private String puesto;
    private String anio;
    private String descripcionTrabajo;

    public Experiencia() {
    }

    public Experiencia(String imgExperiencia, String puesto, String anio, String descripcionTrabajo) {
        this.imgExperiencia = imgExperiencia;
        this.puesto = puesto;
        this.anio = anio;
        this.descripcionTrabajo = descripcionTrabajo;
    }
    
}
