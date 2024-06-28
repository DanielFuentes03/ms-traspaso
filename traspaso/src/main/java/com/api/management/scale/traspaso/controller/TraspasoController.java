package com.api.management.scale.traspaso.controller;

import com.api.management.scale.traspaso.model.Traspaso;
import com.api.management.scale.traspaso.service.TraspasoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("v1/traspaso")
public class TraspasoController {

    @Autowired
    private TraspasoService traspServ;

    @GetMapping()
    public ResponseEntity<List<Traspaso>> listaTraspasos() {
        List<Traspaso> traspasos = traspServ.listAll();
        if (traspasos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(traspasos, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traspaso> buscarporid (@PathVariable(name = "id") Long id){
        Traspaso traspasoencontrado = traspServ.get(id);
        if(traspasoencontrado == null){
            return ResponseEntity.noContent().build();
        }else{
            traspasoencontrado.setEstatus(calculaEstatus());
            return new ResponseEntity<>(traspasoencontrado,HttpStatus.OK);
        }
    }

    //calculaEstatus()
    public String calculaEstatus(){
        HashMap<Integer, String> estatus = new HashMap<Integer, String>();
        estatus.put(1,"RECIBIDA");
        estatus.put(2,"PROCESADA");
        estatus.put(3,"ENVIADA A BRANCH OFFICE");
        estatus.put(4,"RECHAZADA");
        int numeroAleatorio = (int)(Math.random() * 4)+1;
        return estatus.get(numeroAleatorio);
    }

    @PostMapping()
    public ResponseEntity<Traspaso> nuevoTraspaso(@Valid @RequestBody Traspaso t){
        return new ResponseEntity<>(traspServ.save(t),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Traspaso> borrarTraspaso(@PathVariable Long id){
        Traspaso traspasoEncontrado;
        try {
            traspasoEncontrado = traspServ.get(id);
        }catch(Exception e){
            return ResponseEntity.noContent().build();
        }
        traspServ.delete(traspasoEncontrado.getId());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Traspaso> actualizarTraspaso(@PathVariable(name = "id")Long id , @RequestBody Traspaso input){
        Traspaso traspasoencontrado = traspServ.get(id);
        if(traspasoencontrado != null){
            traspasoencontrado.setId(input.getId());
            traspasoencontrado.setNombre(input.getNombre());
            traspasoencontrado.setApellidoPaterno(input.getApellidoPaterno());
            traspasoencontrado.setApellidoMaterno(input.getApellidoMaterno());
            traspasoencontrado.setNumeroCuenta(input.getNumeroCuenta());
            traspasoencontrado.setNss(input.getNss());
            return new ResponseEntity<>(traspServ.save(traspasoencontrado),HttpStatus.OK);
        }else{
            return ResponseEntity.noContent().build();
        }
    }


}
