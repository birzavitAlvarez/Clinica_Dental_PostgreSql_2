package com.ec2.examen2.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="clinicas")
public class Clinica {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codigoclinica", nullable = false)
    private Long id;

    @Column(name = "nombreclinica", nullable=false,length=40)
    private String nombre;

    @Column(name = "direccionclinica", nullable=false,length=50)
    private String direccion;

    //Relacioanando tablas
    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private Set<Cita> cita = new HashSet<>();

    public Clinica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Cita> getCuenta() {
        return cita;
    }

    public void setCuenta(Set<Cita> cuenta) {
        this.cita = cuenta;
    }
}
