package com.portfoliopaz.paz2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDto {
    
    private String imgCurso;
    private String tituloCurso;
    private String anio;
    private String descripcionCurso;

    public EducacionDto() {
    }

    public EducacionDto(String imgCurso, String tituloCurso, String anio, String descripcionCurso) {
        this.imgCurso = imgCurso;
        this.tituloCurso = tituloCurso;
        this.anio = anio;
        this.descripcionCurso = descripcionCurso;
    }
 
}
