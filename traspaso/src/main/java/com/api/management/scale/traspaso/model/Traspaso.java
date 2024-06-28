package com.api.management.scale.traspaso.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "traspaso")
public class Traspaso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @Column(name = "id")
    private long id;
    @JsonProperty("nombre")
    @Column(name = "nombre")
    private String nombre;
    @JsonProperty("apellidoPaterno")
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @JsonProperty("apellidoMaterno")
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @JsonProperty("numeroCuenta")
    @Column(name = "numeroCuenta")
    private int numeroCuenta;
    @JsonProperty("nss")
    @Column(name = "nss")
    private int nss;
    @Column(name = "estatus")
    private String estatus;
}
