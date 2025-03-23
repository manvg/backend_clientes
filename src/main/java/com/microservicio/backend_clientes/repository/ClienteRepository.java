package com.microservicio.backend_clientes.repository;

import com.microservicio.backend_clientes.model.ClienteDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {

    private final List<ClienteDto> listaClientes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public ClienteRepository() {
        ClienteDto cliente1 = new ClienteDto();
        cliente1.setIdCliente(idGenerator.incrementAndGet());
        cliente1.setNombre("Juan");
        cliente1.setApellido("Pérez");
        cliente1.setRut("12345678-9");
        cliente1.setEmail("juan@example.com");
        cliente1.setContrasena("1234");
        cliente1.setDireccion("Calle Falsa 123");
        cliente1.setEstado(1);
        listaClientes.add(cliente1);
    }

    public List<ClienteDto> findAll() {
        return listaClientes;
    }

    public Optional<ClienteDto> findById(Long id) {
        return listaClientes.stream().filter(c -> c.getIdCliente().equals(id)).findFirst();
    }

    public Optional<ClienteDto> findByRut(String rut) {
        return listaClientes.stream().filter(c -> c.getRut().equalsIgnoreCase(rut)).findFirst();
    }

    public ClienteDto save(ClienteDto cliente) {
        cliente.setIdCliente(idGenerator.incrementAndGet());
        listaClientes.add(cliente);
        return cliente;
    }

    public boolean update(Long id, ClienteDto cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdCliente().equals(id)) {
                cliente.setIdCliente(id);
                listaClientes.set(i, cliente);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Long id) {
        return listaClientes.removeIf(c -> c.getIdCliente().equals(id));
    }
}