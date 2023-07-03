package com.ec2.examen2.dto;

import java.sql.Date;

public class CitaDTO {

    private Long id;
    private Date fecha;

    //Clinica
    private Long codigoclinica;
    private String nombreclinica;
    private String direccionclinica;

    //Dentista
    private Long codigodentista;
    private String nombredentista;
    private String apellidodentista;
    private String colegiaturadentista;
    private String especialidaddentista;

    //Tratamiento
    private Long codigotratamiento;
    private Double costotratamiento;
    private String descripciontratamiento;

    //Cliente
    private Long   codigocliente;
    private String nombrecliente;
    private String apellidocliente;
    private String edadcliente;
    private String sexocliente;
    private String direccioncliente;

    public CitaDTO() {
    }

    public CitaDTO(Long id, Date fecha, Long codigoclinica, String nombreclinica, String direccionclinica, Long codigodentista, String nombredentista, String apellidodentista, String colegiaturadentista, String especialidaddentista, Long codigotratamiento, Double costotratamiento, String descripciontratamiento, Long codigocliente, String nombrecliente, String apellidocliente, String edadcliente, String sexocliente, String direccioncliente) {
        this.id = id;
        this.fecha = fecha;
        this.codigoclinica = codigoclinica;
        this.nombreclinica = nombreclinica;
        this.direccionclinica = direccionclinica;
        this.codigodentista = codigodentista;
        this.nombredentista = nombredentista;
        this.apellidodentista = apellidodentista;
        this.colegiaturadentista = colegiaturadentista;
        this.especialidaddentista = especialidaddentista;
        this.codigotratamiento = codigotratamiento;
        this.costotratamiento = costotratamiento;
        this.descripciontratamiento = descripciontratamiento;
        this.codigocliente = codigocliente;
        this.nombrecliente = nombrecliente;
        this.apellidocliente = apellidocliente;
        this.edadcliente = edadcliente;
        this.sexocliente = sexocliente;
        this.direccioncliente = direccioncliente;
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

    public Long getCodigoclinica() {
        return codigoclinica;
    }

    public void setCodigoclinica(Long codigoclinica) {
        this.codigoclinica = codigoclinica;
    }

    public String getNombreclinica() {
        return nombreclinica;
    }

    public void setNombreclinica(String nombreclinica) {
        this.nombreclinica = nombreclinica;
    }

    public String getDireccionclinica() {
        return direccionclinica;
    }

    public void setDireccionclinica(String direccionclinica) {
        this.direccionclinica = direccionclinica;
    }

    public Long getCodigodentista() {
        return codigodentista;
    }

    public void setCodigodentista(Long codigodentista) {
        this.codigodentista = codigodentista;
    }

    public String getNombredentista() {
        return nombredentista;
    }

    public void setNombredentista(String nombredentista) {
        this.nombredentista = nombredentista;
    }

    public String getApellidodentista() {
        return apellidodentista;
    }

    public void setApellidodentista(String apellidodentista) {
        this.apellidodentista = apellidodentista;
    }

    public String getColegiaturadentista() {
        return colegiaturadentista;
    }

    public void setColegiaturadentista(String colegiaturadentista) {
        this.colegiaturadentista = colegiaturadentista;
    }

    public String getEspecialidaddentista() {
        return especialidaddentista;
    }

    public void setEspecialidaddentista(String especialidaddentista) {
        this.especialidaddentista = especialidaddentista;
    }

    public Long getCodigotratamiento() {
        return codigotratamiento;
    }

    public void setCodigotratamiento(Long codigotratamiento) {
        this.codigotratamiento = codigotratamiento;
    }

    public Double getCostotratamiento() {
        return costotratamiento;
    }

    public void setCostotratamiento(Double costotratamiento) {
        this.costotratamiento = costotratamiento;
    }

    public String getDescripciontratamiento() {
        return descripciontratamiento;
    }

    public void setDescripciontratamiento(String descripciontratamiento) {
        this.descripciontratamiento = descripciontratamiento;
    }

    public Long getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(Long codigocliente) {
        this.codigocliente = codigocliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getApellidocliente() {
        return apellidocliente;
    }

    public void setApellidocliente(String apellidocliente) {
        this.apellidocliente = apellidocliente;
    }

    public String getEdadcliente() {
        return edadcliente;
    }

    public void setEdadcliente(String edadcliente) {
        this.edadcliente = edadcliente;
    }

    public String getSexocliente() {
        return sexocliente;
    }

    public void setSexocliente(String sexocliente) {
        this.sexocliente = sexocliente;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }
}
