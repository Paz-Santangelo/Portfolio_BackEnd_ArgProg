package com.portfoliopaz.paz2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadBlandaDto {
    
    private int porcentaje;
    private String nombre;

    public HabilidadBlandaDto() {
    }

    public HabilidadBlandaDto(int porcentaje, String nombre) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }
    
    
}
