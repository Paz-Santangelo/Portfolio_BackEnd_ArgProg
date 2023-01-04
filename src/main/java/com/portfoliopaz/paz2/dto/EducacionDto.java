package com.portfoliopaz.paz2.dto;

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

    public String getImgCurso() {
        return imgCurso;
    }

    public void setImgCurso(String imgCurso) {
        this.imgCurso = imgCurso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

}
