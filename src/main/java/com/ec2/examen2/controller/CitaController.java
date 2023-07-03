package com.ec2.examen2.controller;

import com.ec2.examen2.dto.CitaDTO;
import com.ec2.examen2.entity.Cita;
import com.ec2.examen2.service.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping(path="/cita")
public class CitaController {


    @Autowired
    private CitaService citaService;

    // READ ALL
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Cita> citas = citaService.findAll();
        List<CitaDTO> citasDTO = new ArrayList<>();
        for(Cita cita: citas) {
            CitaDTO citaDTO = new CitaDTO
                    (
                            cita.getId(),
                            cita.getFecha(),
                            cita.getClinica().getId(),
                            cita.getClinica().getNombre(),
                            cita.getClinica().getDireccion(),
                            cita.getDentista().getId(),
                            cita.getDentista().getNombre(),
                            cita.getDentista().getApellido(),
                            cita.getDentista().getColegiatura(),
                            cita.getDentista().getEspecialidad(),
                            cita.getTratamiento().getId(),
                            cita.getTratamiento().getCosto(),
                            cita.getTratamiento().getDescripcion(),
                            cita.getCliente().getId(),
                            cita.getCliente().getNombre(),
                            cita.getCliente().getApellido(),
                            cita.getCliente().getEdad(),
                            cita.getCliente().getSexo(),
                            cita.getCliente().getDireccion()
                    );
            citasDTO.add(citaDTO);
        }
        // Map<String,Object> respuesta = new HashMap<>();
        // respuesta.put("status",200);
        // respuesta.put("data", citasDTO);
        return ResponseEntity.ok(citasDTO);//(respuesta)
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Cita> citaOptional = citaService.findById(id);
        if(citaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        CitaDTO citaDTO = new CitaDTO
                (
                        citaOptional.get().getId(),
                        citaOptional.get().getFecha(),

                        citaOptional.get().getClinica().getId(),
                        citaOptional.get().getClinica().getNombre(),
                        citaOptional.get().getClinica().getDireccion(),

                        citaOptional.get().getDentista().getId(),
                        citaOptional.get().getDentista().getNombre(),
                        citaOptional.get().getDentista().getApellido(),
                        citaOptional.get().getDentista().getColegiatura(),
                        citaOptional.get().getDentista().getEspecialidad(),

                        citaOptional.get().getTratamiento().getId(),
                        citaOptional.get().getTratamiento().getCosto(),
                        citaOptional.get().getTratamiento().getDescripcion(),

                        citaOptional.get().getCliente().getId(),
                        citaOptional.get().getCliente().getNombre(),
                        citaOptional.get().getCliente().getApellido(),
                        citaOptional.get().getCliente().getEdad(),
                        citaOptional.get().getCliente().getSexo(),
                        citaOptional.get().getCliente().getDireccion()
                );
        // Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", tratamientoDTO);
        return ResponseEntity.ok(citaDTO); //(respuesta)
    }
    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cita cita){
        citaService.save(cita);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    /*
    {
        "fecha": "2023-07-15",
        "clinica": {
            "id": 2
        },
        "dentista":{
            "id": 2
        },
        "tratamiento":{
            "id": 2
        },
        "cliente":{
            "id": 2
        }
    }
    */

    // UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cita cita,@PathVariable Long id){
        Optional<Cita> citaOptional= citaService.findById(id);
        if(citaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cita.setId(id);
        citaService.save(cita);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    /*
    {
        "id": 3,
        "fecha": "2023-07-25",
        "clinica": {
            "id": 1
        },
        "dentista":{
            "id": 1
        },
        "tratamiento":{
            "id": 1
        },
        "cliente":{
            "id": 1
        }
    }
    */

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Cita> citaOptional= citaService.findById(id);
        if(citaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        citaService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
}
