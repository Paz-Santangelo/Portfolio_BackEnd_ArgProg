package com.portfoliopaz.paz2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDto {
    
    private String imgPerfil;
    private String nombreCompleto;
    private String titulo;
    private String acerca;

    public PersonaDto() {
    }

    public PersonaDto(String imgPerfil, String nombreCompleto, String titulo, String acerca) {
        this.imgPerfil = imgPerfil;
        this.nombreCompleto = nombreCompleto;
        this.titulo = titulo;
        this.acerca = acerca;
    }

}
