package com.compas.app.service;

import com.compas.app.model.MeEntona;
import com.compas.app.repository.MeEntonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeEntonaService {
     private  final MeEntonaRepository meEntonaRepository;
    @Autowired
    public MeEntonaService(MeEntonaRepository meEntonaRepository) {
        this.meEntonaRepository = meEntonaRepository;
    }
    public List<MeEntona> getAllMeEntona(){
        return meEntonaRepository.findAll();
    }

    public void deleteById(Long idMeEntona) {
        if(!meEntonaRepository.existsById(idMeEntona)){
            throw new IllegalStateException("No podemos encontrar el usuario con el ID: "+idMeEntona);
        }
        meEntonaRepository.deleteById(idMeEntona);
    }

    public MeEntona addNewMeEntona(MeEntona meEntonaUpdate) {
        return meEntonaRepository.save(meEntonaUpdate);
    }

   /* public MeEntona updateMeEntona(Long idMeEntona, MeEntona updateMeEntona) {
        if (!meEntonaRepository.existsById(idMeEntona)) {
            throw new IllegalStateException("No podemos encontrar el usuario con el ID : " + idMeEntona);
        }
        MeEntona meEntona = meEntonaRepository.findMeEntonaByIdMeEntona(idMeEntona).orElseThrow(()-> {
            throw new IllegalStateException("No podemos encontrar el usuario con el ID: "+idMeEntona);
        });
        if ()
    } */


}
