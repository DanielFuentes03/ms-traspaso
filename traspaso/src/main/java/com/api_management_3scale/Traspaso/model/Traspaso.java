package com.api_management_3scale.Traspaso.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Traspaso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private long id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido_paterno")
    private String apellido_paterno;
    @JsonProperty("apellido_materno")
    private String apellido_materno;
    @JsonProperty("numero_cuenta")
    private int numero_cuenta;
    @JsonProperty("nss")
    private int nss;
    private String estatus;
}
