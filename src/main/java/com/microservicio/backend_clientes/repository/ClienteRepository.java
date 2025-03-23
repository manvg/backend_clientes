package com.microservicio.backend_clientes.repository;

import com.microservicio.backend_clientes.model.ClienteDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {

    private final List<ClienteDto> listaClientes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    //#region Lista con clientes
    public ClienteRepository() {
        ClienteDto c1 = new ClienteDto();
        c1.setIdCliente(idGenerator.incrementAndGet());
        c1.setNombre("Camila");
        c1.setApellido("Fernández");
        c1.setRut("12345678-9");
        c1.setEmail("camila.fernandez@mail.com");
        c1.setContrasena("pass123");
        c1.setDireccion("Av. Los Leones 123");
        c1.setEstado(1);
        listaClientes.add(c1);
    
        ClienteDto c2 = new ClienteDto();
        c2.setIdCliente(idGenerator.incrementAndGet());
        c2.setNombre("Rodrigo");
        c2.setApellido("Martínez");
        c2.setRut("98765432-1");
        c2.setEmail("rodrigo.martinez@mail.com");
        c2.setContrasena("rodrigo2023");
        c2.setDireccion("Calle San Diego 456");
        c2.setEstado(1);
        listaClientes.add(c2);
    
        ClienteDto c3 = new ClienteDto();
        c3.setIdCliente(idGenerator.incrementAndGet());
        c3.setNombre("Verónica");
        c3.setApellido("Salazar");
        c3.setRut("24681357-0");
        c3.setEmail("vero.salazar@mail.com");
        c3.setContrasena("v3r0n1ca");
        c3.setDireccion("Pje. El Bosque 789");
        c3.setEstado(1);
        listaClientes.add(c3);
    
        ClienteDto c4 = new ClienteDto();
        c4.setIdCliente(idGenerator.incrementAndGet());
        c4.setNombre("Esteban");
        c4.setApellido("Ríos");
        c4.setRut("13579246-8");
        c4.setEmail("esteban.rios@mail.com");
        c4.setContrasena("rios123");
        c4.setDireccion("Villa Los Aromos 102");
        c4.setEstado(1);
        listaClientes.add(c4);
    
        ClienteDto c5 = new ClienteDto();
        c5.setIdCliente(idGenerator.incrementAndGet());
        c5.setNombre("Daniela");
        c5.setApellido("Aravena");
        c5.setRut("10293847-6");
        c5.setEmail("daniela.aravena@mail.com");
        c5.setContrasena("daniela2024");
        c5.setDireccion("Av. Independencia 333");
        c5.setEstado(1);
        listaClientes.add(c5);
    }
    //#endregion

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