package com.portfoliopaz.paz2.dto;

public class HabilidadBlandaDto {
    
    private int porcentaje;
    private String nombre;

    public HabilidadBlandaDto() {
    }

    public HabilidadBlandaDto(int porcentaje, String nombre) {
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
