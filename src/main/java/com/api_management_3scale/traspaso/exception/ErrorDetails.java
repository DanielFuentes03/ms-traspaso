package com.api_management_3scale.traspaso.exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private String titulo;
    private int estatus;
    private String detalle;
    private long timeStamp;
    private String developerMessage;

}
