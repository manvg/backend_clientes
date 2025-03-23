package com.microservicio.backend_clientes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.backend_clientes.model.ClienteDto;
import com.microservicio.backend_clientes.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> getAllClientes() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        return clienteService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody @Valid ClienteDto cliente) {
        if (clienteService.getAll().stream().anyMatch(c -> c.getRut().equalsIgnoreCase(cliente.getRut()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya existe un cliente con ese RUT");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.create(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody @Valid ClienteDto cliente) {
        return clienteService.update(id, cliente)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        boolean deleted = clienteService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
}
