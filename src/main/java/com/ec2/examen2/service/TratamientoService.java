package com.ec2.examen2.service;

import com.ec2.examen2.entity.Tratamiento;

import java.util.*;

public interface TratamientoService {
    public List<Tratamiento> findAll();
    public Optional<Tratamiento> findById(Long id);
    public void save(Tratamiento tratamiento);
    public void deleteById(Long id);
}
