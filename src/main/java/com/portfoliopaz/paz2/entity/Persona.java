package com.portfoliopaz.paz2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

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
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id") 
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Experiencia> experiencias;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id") 
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Educacion> educacion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id") 
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<HabilidadDura> HabilidadesDuras;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id") 
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<HabilidadBlanda> habilidadesBlandas;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id") 
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Proyecto> proyecto;

    
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

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

    public List<HabilidadDura> getHabilidadesDuras() {
        return HabilidadesDuras;
    }

    public void setHabilidadesDuras(List<HabilidadDura> HabilidadesDuras) {
        this.HabilidadesDuras = HabilidadesDuras;
    }

    public List<HabilidadBlanda> getHabilidadesBlandas() {
        return habilidadesBlandas;
    }

    public void setHabilidadesBlandas(List<HabilidadBlanda> habilidadesBlandas) {
        this.habilidadesBlandas = habilidadesBlandas;
    }

    public List<Proyecto> getProyecto() {
        return proyecto;
    }

    public void setProyecto(List<Proyecto> proyecto) {
        this.proyecto = proyecto;
    }

}
