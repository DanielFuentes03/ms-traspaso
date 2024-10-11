package com.api_management_3scale.traspaso.exception.handler;

import com.api_management_3scale.traspaso.exception.ErrorDetails;
import com.api_management_3scale.traspaso.exception.ResourceNotContentException;
import com.api_management_3scale.traspaso.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotContentException.class)
    public ResponseEntity<?> handleResourceNotContentException(ResourceNotContentException exception, HttpServletRequest httpServletRequest){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimeStamp(new Date().getTime());
        errorDetails.setEstatus(HttpStatus.NO_CONTENT.value());
        errorDetails.setTitulo("Recurso no encontrado.");
        errorDetails.setDetalle(exception.getClass().getName());
        errorDetails.setDeveloperMessage(exception.getMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest httpServletRequest){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimeStamp(new Date().getTime());
        errorDetails.setEstatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setTitulo("Recurso no encontrado.");
        errorDetails.setDetalle(exception.getClass().getName());
        errorDetails.setDeveloperMessage(exception.getMessage());

        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }




}
