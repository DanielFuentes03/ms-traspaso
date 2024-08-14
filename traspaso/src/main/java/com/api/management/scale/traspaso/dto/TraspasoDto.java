package com.api.management.scale.traspaso.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TraspasoDto {

    private long id;

    @NotEmpty(message = "Nombre no puede estar vacío.")
    private String nombre;

    @NotEmpty(message = "Apellido Paterno no puede estar vacío.")
    private String apellidoPaterno;

    @NotEmpty(message = "Apellido Materno no puede estar vacío.")
    private String apellidoMaterno;

    private int numeroCuenta;

    private int nss;

    private String estatus;

}
