package com.ec2.examen2.controller;

import com.ec2.examen2.dto.DentistaDTO;
import com.ec2.examen2.entity.Dentista;
import com.ec2.examen2.service.DentistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping(path="/dentista")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    // READ ALL
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Dentista> dentistas = dentistaService.findAll();
        List<DentistaDTO> dentistasDTO = new ArrayList<>();
        for(Dentista dentista: dentistas) {
            DentistaDTO bancoDTO = new DentistaDTO
                    (
                            dentista.getId(),
                            dentista.getNombre(),
                            dentista.getApellido(),
                            dentista.getColegiatura(),
                            dentista.getEspecialidad()
                    );
            dentistasDTO.add(bancoDTO);
        }
        // Map<String,Object> respuesta = new HashMap<>();
        // respuesta.put("status",200);
        // respuesta.put("data", dentistasDTO);
        return ResponseEntity.ok(dentistasDTO);//(respuesta)
    }
    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Dentista> dentistaOptional = dentistaService.findById(id);
        if(dentistaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DentistaDTO dentistaDTO = new DentistaDTO
                (
                        dentistaOptional.get().getId(),
                        dentistaOptional.get().getNombre(),
                        dentistaOptional.get().getApellido(),
                        dentistaOptional.get().getColegiatura(),
                        dentistaOptional.get().getEspecialidad()
                );
        // Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", dentistaDTO);
        return ResponseEntity.ok(dentistaDTO); //(respuesta)
    }
    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dentista dentista){
        dentistaService.save(dentista);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Dentista dentista,@PathVariable Long id){
        Optional<Dentista> dentistaOptional= dentistaService.findById(id);
        if(dentistaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        dentista.setId(id);
        dentistaService.save(dentista);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Dentista> clinicaOptional= dentistaService.findById(id);
        if(clinicaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        dentistaService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }


}
