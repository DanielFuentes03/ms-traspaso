package com.api.management.scale.traspaso.service;

import com.api.management.scale.traspaso.dto.TraspasoDto;
import com.api.management.scale.traspaso.model.Traspaso;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ITraspasoService {


    public List<TraspasoDto> listAll();

    public Optional<Traspaso> getOptional(Long id);

    public Traspaso save(Traspaso traspaso);

    public void delete(Long id);

}
