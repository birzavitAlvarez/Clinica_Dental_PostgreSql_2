package com.ec2.examen2.service;

import java.util.List;
import java.util.Optional;

import com.ec2.examen2.entity.Dentista;
import com.ec2.examen2.repository.DentistaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistaServiceImpl implements DentistaService{

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Dentista> findAll() {
        return dentistaRepository.findAll();
    }

    @Override
    public Optional<Dentista> findById(Long id) {
        return dentistaRepository.findById(id);
    }

    @Override
    public void save(Dentista dentista) {
        dentistaRepository.save(dentista);
    }

    @Override
    public void deleteById(Long id) {
        dentistaRepository.deleteById(id);
    }
}
