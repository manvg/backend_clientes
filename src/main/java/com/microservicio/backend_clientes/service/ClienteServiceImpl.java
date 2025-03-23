package com.microservicio.backend_clientes.service;

import com.microservicio.backend_clientes.model.ClienteDto;
import com.microservicio.backend_clientes.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteDto> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClienteDto> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ClienteDto create(ClienteDto cliente) {
        return repository.save(cliente);
    }

    @Override
    public Optional<ClienteDto> update(Long id, ClienteDto cliente) {
        boolean updated = repository.update(id, cliente);
        return updated ? Optional.of(cliente) : Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}