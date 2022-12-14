package com.portfoliopaz.paz2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    
    private String imgExperiencia;
    private String puesto;
    private String anio;
    private String descripcionTrabajo;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String imgExperiencia, String puesto, String anio, String descripcionTrabajo) {
        this.imgExperiencia = imgExperiencia;
        this.puesto = puesto;
        this.anio = anio;
        this.descripcionTrabajo = descripcionTrabajo;
    }

}
