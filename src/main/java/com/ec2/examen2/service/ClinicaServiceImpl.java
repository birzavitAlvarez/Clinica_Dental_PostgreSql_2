package com.ec2.examen2.service;

import java.util.List;
import java.util.Optional;

import com.ec2.examen2.entity.Clinica;
import com.ec2.examen2.repository.ClinicaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Clinica> findAll() {
        return clinicaRepository.findAll();
    }

    @Override
    public Optional<Clinica> findById(Long id) {
        return clinicaRepository.findById(id);
    }

    @Override
    public void save(Clinica clinica) {
        clinicaRepository.save(clinica);
    }

    @Override
    public void deleteById(Long id) {
        clinicaRepository.deleteById(id);
    }
}
