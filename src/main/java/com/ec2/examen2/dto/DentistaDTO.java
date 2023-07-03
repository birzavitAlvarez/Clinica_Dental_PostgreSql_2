package com.ec2.examen2.dto;

public class DentistaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String colegiatura;
    private String especialidad;

    public DentistaDTO() {
    }

    public DentistaDTO(Long id, String nombre, String apellido, String colegiatura, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.colegiatura = colegiatura;
        this.especialidad = especialidad;
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
}
