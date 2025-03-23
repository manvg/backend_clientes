package com.microservicio.backend_clientes.service;

import com.microservicio.backend_clientes.model.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<ClienteDto> getAll();

    Optional<ClienteDto> getById(Long id);

    ClienteDto create(ClienteDto cliente);

    Optional<ClienteDto> update(Long id, ClienteDto cliente);

    boolean delete(Long id);
}
