package com.api_management_3scale.traspaso.service;


import com.api_management_3scale.traspaso.dto.TraspasoDto;
import com.api_management_3scale.traspaso.model.Traspaso;
import java.util.List;

public interface ITraspasoService {

    public List<TraspasoDto> listAll();

    public TraspasoDto getById(Long id);

    public Traspaso save(TraspasoDto traspasoDto);

    public String delete(Long id);

    public Traspaso update(Long id,TraspasoDto traspasoDto);
}
