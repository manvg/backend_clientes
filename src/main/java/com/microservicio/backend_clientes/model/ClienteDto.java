package com.microservicio.backend_clientes.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClienteDto {

    private Long idCliente;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100, message = "El apellido no puede tener más de 100 caracteres")
    private String apellido;

    @NotBlank(message = "El RUT es obligatorio")
    @Size(max = 20, message = "El RUT no puede tener más de 20 caracteres")
    private String rut;

    @Email(message = "Formato de email no válido")
    @Size(max = 150, message = "El correo no puede tener más de 150 caracteres")
    private String email;

    @Size(max = 20, message = "La contraseña no puede tener más de 20 caracteres")
    private String contrasena;

    @Size(max = 250, message = "La dirección no puede tener más de 250 caracteres")
    private String direccion;

    @NotNull(message = "El estado es obligatorio")
    @Min(value = 0, message = "Estado inválido (debe ser 0 o 1)")
    @Max(value = 1, message = "Estado inválido (debe ser 0 o 1)")
    private Integer estado = 1;
}