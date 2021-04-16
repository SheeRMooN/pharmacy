package com.voronuyk.pharmacy.service;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.repository.DoctorRepo;
import com.voronuyk.pharmacy.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private PetRepo petRepo;

    public List<DoctorEntity> findAllBy() {
        return doctorRepo.findAll();
    }
    public Optional<DoctorEntity> findById(Long id){
        return doctorRepo.findById(id);
    }
    public DoctorEntity create( DoctorEntity doctorEntity){
        doctorRepo.save(doctorEntity);
        return doctorEntity;
    }
    public String delete( Long id){
        doctorRepo.deleteById(id);
        return "Success delete doctor : " + id;
    }

    public String createPet( PetEntity petEntity,  Long id){
//        PetEntity pet = petRepo.save(petEntity);
        DoctorEntity doctorEntity = doctorRepo.findById(id).get(); //+
        doctorEntity.addPet(petEntity);
        petEntity.setDoctor(doctorEntity); //+
        doctorRepo.save(doctorEntity);
        return "doctor : " + id + "\npet : " +petEntity.getId();
    }
    public DoctorEntity addPetInDoctor(Long doctorId, Long petId){
        DoctorEntity doctorEntity = doctorRepo.findById(doctorId).get();
        PetEntity petEntity = petRepo.findById(petId).get();
        doctorEntity.addPet(petEntity);
        petEntity.setDoctor(doctorEntity);
        return doctorRepo.save(doctorEntity);
    }
}
