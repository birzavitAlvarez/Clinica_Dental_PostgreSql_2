package com.ec2.examen2.service;

import com.ec2.examen2.entity.Cliente;

import java.util.*;

public interface ClienteService {
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public void save(Cliente cliente);
    public void deleteById(Long id);
}
