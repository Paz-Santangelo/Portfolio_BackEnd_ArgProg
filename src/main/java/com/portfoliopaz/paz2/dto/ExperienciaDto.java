package com.portfoliopaz.paz2.dto;

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

    public String getImgExperiencia() {
        return imgExperiencia;
    }

    public void setImgExperiencia(String imgExperiencia) {
        this.imgExperiencia = imgExperiencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

}
