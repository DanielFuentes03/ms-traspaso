package com.api.management.scale.traspaso.service;

import com.api.management.scale.traspaso.model.Traspaso;
import com.api.management.scale.traspaso.repository.TraspasoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class TraspasoService {

    @Autowired
    private TraspasoRepository traspRepo;

    public List<Traspaso> listAll(){return traspRepo.findAll();}

    public Traspaso get(Long id){ return traspRepo.findById(id).get();}

    public Traspaso save(Traspaso traspaso){return traspRepo.save(traspaso);}

    public void delete(Long id){traspRepo.deleteById(id);}
}
