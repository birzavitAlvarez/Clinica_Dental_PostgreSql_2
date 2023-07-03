package com.ec2.examen2.dto;

public class TratamientoDTO {

    private Long id;
    private Double costo;
    private String descripcion;

    public TratamientoDTO() {
    }

    public TratamientoDTO(Long id, Double costo, String descripcion) {
        this.id = id;
        this.costo = costo;
        this.descripcion = descripcion;
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
}
