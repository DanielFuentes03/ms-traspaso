package com.api_management_3scale.traspaso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ResourceNotContentException extends RuntimeException{

    private static final long serialVersionUID =1L;

    public ResourceNotContentException(){}

    public ResourceNotContentException(String mensaje){
        super(mensaje);
    }

    public ResourceNotContentException(String mensaje, Throwable causa){
        super(mensaje,causa);
    }

}
