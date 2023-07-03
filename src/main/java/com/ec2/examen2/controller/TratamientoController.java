package com.ec2.examen2.controller;

import com.ec2.examen2.dto.TratamientoDTO;
import com.ec2.examen2.entity.Tratamiento;
import com.ec2.examen2.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping(path="/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    // READ ALL
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Tratamiento> tratamientos = tratamientoService.findAll();
        List<TratamientoDTO> tratamientosDTO = new ArrayList<>();
        for(Tratamiento tratamiento: tratamientos) {
            TratamientoDTO tratamientoDTO = new TratamientoDTO
                    (
                            tratamiento.getId(),
                            tratamiento.getCosto(),
                            tratamiento.getDescripcion()
                    );
            tratamientosDTO.add(tratamientoDTO);
        }
        // Map<String,Object> respuesta = new HashMap<>();
        // respuesta.put("status",200);
        // respuesta.put("data", tratamientosDTO);
        return ResponseEntity.ok(tratamientosDTO);//(respuesta)
    }
    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Tratamiento> tratamientoOptional = tratamientoService.findById(id);
        if(tratamientoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        TratamientoDTO tratamientoDTO = new TratamientoDTO
                (
                        tratamientoOptional.get().getId(),
                        tratamientoOptional.get().getCosto(),
                        tratamientoOptional.get().getDescripcion()
                );
        // Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", tratamientoDTO);
        return ResponseEntity.ok(tratamientoDTO); //(respuesta)
    }
    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tratamiento tratamiento){
        tratamientoService.save(tratamiento);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Tratamiento tratamiento,@PathVariable Long id){
        Optional<Tratamiento> tratamientoOptional= tratamientoService.findById(id);
        if(tratamientoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tratamiento.setId(id);
        tratamientoService.save(tratamiento);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Tratamiento> tratamientoOptional= tratamientoService.findById(id);
        if(tratamientoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tratamientoService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }


}
