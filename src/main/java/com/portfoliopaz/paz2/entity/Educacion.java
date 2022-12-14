package com.portfoliopaz.paz2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgCurso;
    private String tituloCurso;
    private String anio;
    
    @Column(name = "descripcion_Curso", length = 800)
    private String descripcionCurso;

    public Educacion() {
    }

    public Educacion(String imgCurso, String tituloCurso, String anio, String descripcionCurso) {
        this.imgCurso = imgCurso;
        this.tituloCurso = tituloCurso;
        this.anio = anio;
        this.descripcionCurso = descripcionCurso;
    }

}
