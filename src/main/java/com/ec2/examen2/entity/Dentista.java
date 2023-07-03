package com.ec2.examen2.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="dentistas")
public class Dentista {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codigodentista", nullable = false)
    private Long id;

    @Column(name = "nombredentista", nullable=false,length=40)
    private String nombre;

    @Column(name = "apellidodentista", nullable=false,length=40)
    private String apellido;

    @Column(name = "colegiaturadentista", nullable=false,length=10)
    private String colegiatura;

    @Column(name = "especialidaddentista", nullable=false,length=40)
    private String especialidad;

    //Relacioanando tablas
    @OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL)
    private Set<Cita> cita = new HashSet<>();

    public Dentista() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Cita> getCuenta() {
        return cita;
    }

    public void setCuenta(Set<Cita> cuenta) {
        this.cita = cuenta;
    }
}
