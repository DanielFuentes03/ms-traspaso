package com.api_management_3scale.traspaso.service;

import com.api_management_3scale.traspaso.model.Traspaso;
import com.api_management_3scale.traspaso.repository.TraspasoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TraspasoServiceImpl implements ITraspasoService {

    private   TraspasoRepository traspRepo;

    public List<Traspaso> listAll(){return traspRepo.findAll();}

    public Optional<Traspaso> getOptional(Long id){ return traspRepo.findById(id);}

    public Traspaso save(Traspaso traspaso){return traspRepo.save(traspaso);}

    public void delete(Long id){traspRepo.deleteById(id);}
}
