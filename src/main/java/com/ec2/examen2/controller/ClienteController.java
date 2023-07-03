package com.ec2.examen2.controller;

import com.ec2.examen2.dto.ClienteDTO;
import com.ec2.examen2.entity.Cliente;
import com.ec2.examen2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping(path="/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // READ ALL
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for(Cliente cliente: clientes) {
            ClienteDTO clienteDTO = new ClienteDTO
                    (
                            cliente.getId(),
                            cliente.getNombre(),
                            cliente.getApellido(),
                            cliente.getEdad(),
                            cliente.getSexo(),
                            cliente.getDireccion()
                    );
            clientesDTO.add(clienteDTO);
        }
        // Map<String,Object> respuesta = new HashMap<>();
        // respuesta.put("status",200);
        // respuesta.put("data", clientesDTO);
        return ResponseEntity.ok(clientesDTO);//(respuesta)
    }
    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ClienteDTO clienteDTO = new ClienteDTO
                (
                        clienteOptional.get().getId(),
                        clienteOptional.get().getNombre(),
                        clienteOptional.get().getApellido(),
                        clienteOptional.get().getEdad(),
                        clienteOptional.get().getSexo(),
                        clienteOptional.get().getDireccion()
                );
        // Map<String, Object> respuesta = new HashMap<>();
        // respuesta.put("status", 200);
        // respuesta.put("data", tratamientoDTO);
        return ResponseEntity.ok(clienteDTO); //(respuesta)
    }
    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        clienteService.save(cliente);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente cliente,@PathVariable Long id){
        Optional<Cliente> clienteOptional= clienteService.findById(id);
        if(clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteService.save(cliente);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Cliente> clienteOptional= clienteService.findById(id);
        if(clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }


}
