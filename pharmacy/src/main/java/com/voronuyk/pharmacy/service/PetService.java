package com.voronuyk.pharmacy.service;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.repository.DoctorRepo;
import com.voronuyk.pharmacy.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepo petRepo;
    @Autowired
    private DoctorRepo doctorRepo;

    public List<PetEntity> findAllBy(){
        return petRepo.findAllBy();
    }
    public Optional<PetEntity> findById(Long id){
        return petRepo.findById(id);
    }
    public PetEntity createByEntity( PetEntity petEntity){
        return petRepo.save(petEntity);
    }
    public String deleteById( Long id){
        petRepo.deleteById(id);
        return "success delete pet : " + id;
    }

//    public PetEntity createPet(@RequestBody PetEntity petEntity, @PathVariable Long doctorId){
//        DoctorEntity doctorEntity = doctorRepo.findById(doctorId).get();
//        doctorEntity.setPet(petEntity);
//        petEntity.setDoctor(doctorEntity);
//        doctorRepo.save(doctorEntity);
//        return petRepo.save(petEntity);
//    }
//    public PetEntity addDoctor(@RequestBody DoctorEntity doctorEntity, @PathVariable Long id){
//        PetEntity petEntity = petRepo.findById(id).get();
//        petEntity.setDoctor(doctorEntity);
//        doctorEntity.setPet(petEntity);
//        doctorRepo.save(doctorEntity);
//        return petRepo.save(petEntity);
//    }

}
