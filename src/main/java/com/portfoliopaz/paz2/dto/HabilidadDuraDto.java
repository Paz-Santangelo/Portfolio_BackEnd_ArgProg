package com.portfoliopaz.paz2.dto;

public class HabilidadDuraDto {
    
    private int porcentaje;
    private String nombre;

    public HabilidadDuraDto() {
    }

    public HabilidadDuraDto(int porcentaje, String nombre) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
