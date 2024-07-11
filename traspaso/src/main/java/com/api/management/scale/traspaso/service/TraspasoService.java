package com.api.management.scale.traspaso.service;

import com.api.management.scale.traspaso.model.Traspaso;
import com.api.management.scale.traspaso.repository.TraspasoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TraspasoService {

    private  final TraspasoRepository traspRepo;

    @Autowired
    public TraspasoService(TraspasoRepository traspRepo){
        this.traspRepo =traspRepo;
    }

    public List<Traspaso> listAll(){return traspRepo.findAll();}

    public Optional<Traspaso> getOptional(Long id){ return traspRepo.findById(id);}

    public Traspaso save(Traspaso traspaso){return traspRepo.save(traspaso);}

    public void delete(Long id){traspRepo.deleteById(id);}
}
