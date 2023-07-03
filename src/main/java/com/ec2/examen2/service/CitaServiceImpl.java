package com.ec2.examen2.service;

import java.util.List;
import java.util.Optional;

import com.ec2.examen2.entity.Cita;
import com.ec2.examen2.repository.CitaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CitaServiceImpl implements CitaService{

    @Autowired
    private CitaRepository citaRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public void save(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }
}
