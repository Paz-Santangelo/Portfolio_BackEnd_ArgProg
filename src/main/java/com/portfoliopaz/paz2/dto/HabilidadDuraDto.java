package com.portfoliopaz.paz2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadDuraDto {
    
    private int porcentaje;
    private String nombre;

    public HabilidadDuraDto() {
    }

    public HabilidadDuraDto(int porcentaje, String nombre) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }

}
