package com.portfoliopaz.paz2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "imgPerfil", length = 600)
    private String imgPerfil;

    private String nombreCompleto;
    
    private String titulo;

    @Lob
    @Column(name = "acerca", length = 600)
    private String acerca;
    
        
    public Persona() {
    }

    public Persona(String imgPerfil, String nombreCompleto, String titulo, String acerca) {
        this.imgPerfil = imgPerfil;
        this.nombreCompleto = nombreCompleto;
        this.titulo = titulo;
        this.acerca = acerca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

}
