package com.api.management.scale.traspaso.service;

import com.api.management.scale.traspaso.model.Traspaso;
import com.api.management.scale.traspaso.repository.TraspasoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ITraspasoService {


    public List<Traspaso> listAll();

    public Optional<Traspaso> getOptional(Long id);

    public Traspaso save(Traspaso traspaso);

    public void delete(Long id);

}
