package com.ec2.examen2.entity;

import java.sql.Date;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="citas")
public class Cita {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="codigocita", nullable = false)
    private Long id;

    @Column(name = "fechacita", nullable=false)
    private Date fecha;


    // Relacionando Tablas
    // Clinica
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigoclinica")
    @JsonProperty(access = Access.WRITE_ONLY)
    Clinica clinica;

    // Dentista
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigodentista")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Dentista dentista;

    // Tratamiento
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigotratamiento")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Tratamiento tratamiento;

    // Cliente
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigocliente")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Cliente cliente;

    public Cita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
