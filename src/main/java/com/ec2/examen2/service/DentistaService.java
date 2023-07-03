package com.ec2.examen2.service;

import com.ec2.examen2.entity.Dentista;

import java.util.*;

public interface DentistaService {
    public List<Dentista> findAll();
    public Optional<Dentista> findById(Long id);
    public void save(Dentista dentista);
    public void deleteById(Long id);
}
