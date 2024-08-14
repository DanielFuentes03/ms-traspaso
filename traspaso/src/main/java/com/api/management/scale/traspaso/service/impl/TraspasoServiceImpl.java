package com.api.management.scale.traspaso.service.impl;

import com.api.management.scale.traspaso.dto.TraspasoDto;
import com.api.management.scale.traspaso.mapper.IAutoTraspasoMapper;
import com.api.management.scale.traspaso.model.Traspaso;
import com.api.management.scale.traspaso.repository.TraspasoRepository;
import com.api.management.scale.traspaso.service.ITraspasoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class TraspasoServiceImpl implements ITraspasoService {

    @Autowired
    private   TraspasoRepository traspRepo;

    @Override
    public List<TraspasoDto> listAll(){
        List<Traspaso> listaTraspasos = traspRepo.findAll();
        if(listaTraspasos.isEmpty()){
            return null;
        } else {
            return listaTraspasos.stream().map(IAutoTraspasoMapper.MAPPER::mapToTraspasoDto).collect(Collectors.toList());
        }
    }

    @Override
    public Optional<Traspaso> getOptional(Long id){ return traspRepo.findById(id);}

    @Override
    public Traspaso save(Traspaso traspaso){return traspRepo.save(traspaso);}

    @Override
    public void delete(Long id){traspRepo.deleteById(id);}
}
