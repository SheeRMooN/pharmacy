package com.voronuyk.pharmacy.service;

import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.exception.PetException;
import com.voronuyk.pharmacy.repository.DoctorRepo;
import com.voronuyk.pharmacy.repository.PetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class PetService {
    private PetRepo petRepo;
    private DoctorRepo doctorRepo;

    public List<PetEntity> findAllBy(){
        return petRepo.findAllBy();
    }
    public PetEntity findById(Long id) throws PetException {
        return petRepo.findById(id).orElseThrow(()->new PetException("pet not found"));
    }
    public PetEntity createByEntity( PetEntity petEntity){
        return petRepo.save(petEntity);
    }
    public void deleteById( Long id){
        petRepo.deleteById(id);
    }
}
