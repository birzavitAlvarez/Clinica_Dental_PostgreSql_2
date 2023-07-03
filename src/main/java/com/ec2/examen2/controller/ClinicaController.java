package com.ec2.examen2.controller;

import com.ec2.examen2.dto.ClinicaDTO;
import com.ec2.examen2.entity.Clinica;
import com.ec2.examen2.service.ClinicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping(path="/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    // READ ALL
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Clinica> clinicas = clinicaService.findAll();
        List<ClinicaDTO> clinicasDTO = new ArrayList<>();
        for(Clinica clinica: clinicas) {
            ClinicaDTO bancoDTO = new ClinicaDTO (clinica.getId(),
                                                  clinica.getNombre(),
                                                  clinica.getDireccion());
            clinicasDTO.add(bancoDTO);
        }
        // Map<String,Object> respuesta = new HashMap<>();
        // respuesta.put("status",200);
        // respuesta.put("data", clinicasDTO);
        return ResponseEntity.ok(clinicasDTO);//(respuesta)
    }
    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Clinica> clinicaOptional = clinicaService.findById(id);
        if(clinicaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ClinicaDTO clinicaDTO = new ClinicaDTO(clinicaOptional.get().getId(),
                                               clinicaOptional.get().getNombre(),
                                               clinicaOptional.get().getDireccion());
        // Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", clinicaDTO);
        return ResponseEntity.ok(clinicaDTO); //(respuesta)
    }
    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Clinica clinica){
        clinicaService.save(clinica);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Clinica clinica,@PathVariable Long id){
        Optional<Clinica> clinicaOptional= clinicaService.findById(id);
        if(clinicaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clinica.setId(id);
        clinicaService.save(clinica);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Clinica> clinicaOptional= clinicaService.findById(id);
        if(clinicaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clinicaService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }


}
