package com.ec2.examen2.service;

import java.util.List;
import java.util.Optional;

import com.ec2.examen2.entity.Tratamiento;
import com.ec2.examen2.repository.TratamientoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoServiceImpl implements TratamientoService{

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public Optional<Tratamiento> findById(Long id) {
        return tratamientoRepository.findById(id);
    }

    @Override
    public void save(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }
}
