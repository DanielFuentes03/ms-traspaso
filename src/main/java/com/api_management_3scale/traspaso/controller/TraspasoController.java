package com.api_management_3scale.traspaso.controller;

import com.api_management_3scale.traspaso.model.Traspaso;
import com.api_management_3scale.traspaso.service.TraspasoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("v1/traspaso")
public class TraspasoController {

    private TraspasoServiceImpl traspServ;

    @Autowired
    public TraspasoController(TraspasoServiceImpl traspServ){
        this.traspServ = traspServ;
    }

    Random aleatorio = new Random();

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
           Optional<Traspaso> traspasoencontrado = traspServ.getOptional(id);
           if(traspasoencontrado.isPresent()){
               traspasoencontrado.get().setEstatus(calculaEstatus());
               return new ResponseEntity<>(traspasoencontrado.get(),HttpStatus.OK);
           }
            return ResponseEntity.noContent().build();
    }

    //calculaEstatus()
    public String calculaEstatus(){
        HashMap<Integer, String> estatus = new HashMap<>();
        estatus.put(0,"RECIBIDA");
        estatus.put(1,"PROCESADA");
        estatus.put(2,"ENVIADA A BRANCH OFFICE");
        estatus.put(3,"RECHAZADA");
        int numeroAleatorio = aleatorio.nextInt(4);
        return estatus.get(numeroAleatorio);
    }

    @PostMapping()
    public ResponseEntity<Traspaso> nuevoTraspaso(@Valid @RequestBody Traspaso t){
        return new ResponseEntity<>(traspServ.save(t),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Traspaso> borrarTraspaso(@PathVariable Long id){
        Optional<Traspaso> traspasoEncontrado = traspServ.getOptional(id);
        if(traspasoEncontrado.isPresent()){
            traspServ.delete(traspasoEncontrado.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traspaso> actualizarTraspaso(@PathVariable(name = "id")Long id , @RequestBody Traspaso input){
        Optional<Traspaso> traspasoEncontrado = traspServ.getOptional(id);
        if(traspasoEncontrado.isPresent()){
            traspasoEncontrado.get().setId(input.getId());
            traspasoEncontrado.get().setNombre(input.getNombre());
            traspasoEncontrado.get().setApellidoPaterno(input.getApellidoPaterno());
            traspasoEncontrado.get().setApellidoMaterno(input.getApellidoMaterno());
            traspasoEncontrado.get().setNumeroCuenta(input.getNumeroCuenta());
            traspasoEncontrado.get().setNss(input.getNss());
            return new ResponseEntity<>(traspServ.save(traspasoEncontrado.get()),HttpStatus.OK);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
