package com.ec2.examen2.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="tratamientos")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codigotratamiento", nullable = false)
    private Long id;

    @Column(name = "costotratamiento", nullable=false)
    private Double costo;

    @Column(name = "descripciontratamiento", nullable=false,length=60)
    private String descripcion;

    //Relacioanando tablas
    @OneToMany(mappedBy = "tratamiento", cascade = CascadeType.ALL)
    private Set<Cita> cita = new HashSet<>();

    public Tratamiento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Cita> getCuenta() {
        return cita;
    }

    public void setCuenta(Set<Cita> cuenta) {
        this.cita = cuenta;
    }
}
