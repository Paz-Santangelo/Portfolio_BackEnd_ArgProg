package com.portfoliopaz.paz2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgProyecto;
    private String nombreProyecto;
    private String descripcionProyecto;
    private String linkProyecto;

    public Proyecto() {
    }

    public Proyecto(String imgProyecto, String nombreProyecto, String descripcionProyecto, String linkProyecto) {
        this.imgProyecto = imgProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.linkProyecto = linkProyecto;
    }
 
}
