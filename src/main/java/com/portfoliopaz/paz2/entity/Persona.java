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
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

}
