package com.ec2.examen2.service;

import com.ec2.examen2.entity.Clinica;

import java.util.*;

public interface ClinicaService {
    public List<Clinica> findAll();
    public Optional<Clinica> findById(Long id);
    public void save(Clinica clinica);
    public void deleteById(Long id);
}
