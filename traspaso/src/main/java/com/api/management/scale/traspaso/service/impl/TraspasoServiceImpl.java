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
            return listaTraspasos.stream()
                    .map(traspaso -> IAutoTraspasoMapper.MAPPER.mapToTraspasoDto(traspaso))
                            .collect(Collectors.toList());
        }
    }

    @Override
    public TraspasoDto getById(Long id){
        //Optional<Traspaso> traspaso = Optional.of(traspRepo.findById(id).get());
        Traspaso traspaso = traspRepo.findById(id).orElse(null);
        if(traspaso != null){
            TraspasoDto traspasoDTO= IAutoTraspasoMapper.MAPPER.mapToTraspasoDto(traspaso);
            if(traspasoDTO != null){
                return traspasoDTO;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Traspaso save(TraspasoDto traspasoDto){
        return traspRepo.save(IAutoTraspasoMapper.MAPPER.mapToTraspaso(traspasoDto));
    }

    @Override
    public String delete(Long id){
        Traspaso traspaso = traspRepo.findById(id).orElse(null);
        if(traspaso != null) {
            traspRepo.deleteById(id);
            return "REGISTRO BORRADO";
        }else{
            return null;
        }
    }

    @Override
    public Traspaso update(Long id,TraspasoDto traspasoDto) {
        Traspaso traspasoInput = IAutoTraspasoMapper.MAPPER.mapToTraspaso(traspasoDto);
        Traspaso traspasoencontrado = traspRepo.findById(id).orElse(null);
        if(traspasoencontrado != null){
          traspasoencontrado.setNombre(traspasoInput.getNombre());
          traspasoencontrado.setApellidoPaterno(traspasoInput.getApellidoPaterno());
          traspasoencontrado.setApellidoMaterno(traspasoInput.getApellidoPaterno());
          traspasoencontrado.setNss(traspasoInput.getNss());
          traspasoencontrado.setNumeroCuenta(traspasoInput.getNumeroCuenta());
          traspasoencontrado.setEstatus(traspasoInput.getEstatus());
          return traspRepo.save(traspasoencontrado);
        }
        else{
            return null;
        }
    }
}
