package com.ec2.examen2.entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codigocliente", nullable = false)
    private Long id;

    @Column(name = "nombrecliente", nullable=false,length=40)
    private String nombre;

    @Column(name = "apellidocliente", nullable=false,length=40)
    private String apellido;

    @Column(name = "edadcliente", nullable=false,length=2)
    private String edad;

    @Column(name = "sexocliente", nullable=false,length=1)
    private String sexo;

    @Column(name = "direccioncliente", nullable=false,length=40)
    private String direccion;

    //Relacioanando tablas
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Cita> cita = new HashSet<>();

    public Cliente() {
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
