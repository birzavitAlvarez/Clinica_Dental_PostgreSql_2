package com.ec2.examen2.repository;

import com.ec2.examen2.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository <Dentista, Long>{
}
