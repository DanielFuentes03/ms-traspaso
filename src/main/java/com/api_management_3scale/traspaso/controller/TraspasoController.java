package com.api_management_3scale.traspaso.controller;

import com.api_management_3scale.traspaso.dto.TraspasoDto;
import com.api_management_3scale.traspaso.model.Traspaso;
import com.api_management_3scale.traspaso.service.ITraspasoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("v1/traspaso")
@AllArgsConstructor
@NoArgsConstructor
public class TraspasoController {

    @Autowired
    private ITraspasoService traspServ;

    Random aleatorio = new Random();

    @GetMapping()
    public ResponseEntity<List<TraspasoDto>> listaTraspasos() {
        List<TraspasoDto> traspasos = traspServ.listAll();
        if(traspasos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(traspasos,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraspasoDto> buscarporid (@PathVariable(name = "id") Long id){
        TraspasoDto traspasoencontrado = traspServ.getById(id);
        if(traspasoencontrado != null){
            traspasoencontrado.setEstatus(calculaEstatus());
            return new ResponseEntity<>(traspasoencontrado,HttpStatus.OK);
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
    public ResponseEntity<Traspaso> nuevoTraspaso(@Valid @RequestBody TraspasoDto traspasoDto){
        return new ResponseEntity<>(traspServ.save(traspasoDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Traspaso> borrarTraspaso(@PathVariable Long id){
        String respuesta = traspServ.delete(id);
        if(respuesta == null){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traspaso> actualizarTraspaso(@PathVariable(name = "id")Long id , @RequestBody TraspasoDto input){
        Traspaso traspaso = traspServ.update(id,input);
        if(traspaso == null){
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(traspaso,HttpStatus.OK);
        }
    }
}
