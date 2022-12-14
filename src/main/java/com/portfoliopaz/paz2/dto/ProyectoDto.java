package com.portfoliopaz.paz2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDto {
    
    private String imgProyecto;
    private String nombreProyecto;
    private String descripcionProyecto;
    private String linkProyecto;

    public ProyectoDto() {
    }

    public ProyectoDto(String imgProyecto, String nombreProyecto, String descripcionProyecto, String linkProyecto) {
        this.imgProyecto = imgProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.linkProyecto = linkProyecto;
    }
  
}
