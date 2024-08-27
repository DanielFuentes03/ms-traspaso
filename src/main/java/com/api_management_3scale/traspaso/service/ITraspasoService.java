package com.api_management_3scale.traspaso.service;

import com.api_management_3scale.traspaso.model.Traspaso;

import java.util.List;
import java.util.Optional;

public interface ITraspasoService {


    public List<Traspaso> listAll();

    public Optional<Traspaso> getOptional(Long id);

    public Traspaso save(Traspaso traspaso);

    public void delete(Long id);

}
