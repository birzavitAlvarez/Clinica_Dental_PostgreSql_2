package com.ec2.examen2.repository;

import com.ec2.examen2.entity.Clinica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository <Clinica, Long> {
}
