package com.ec2.examen2.service;

import com.ec2.examen2.entity.Cita;

import java.util.*;

public interface CitaService {
    public List<Cita> findAll();
    public Optional<Cita> findById(Long id);
    public void save(Cita cita);
    public void deleteById(Long id);
}
