package com.voronuyk.pharmacy.service;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.exception.DoctorException;
import com.voronuyk.pharmacy.exception.PetException;
import com.voronuyk.pharmacy.repository.DoctorRepo;
import com.voronuyk.pharmacy.repository.PetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {
    private DoctorRepo doctorRepo;
    private PetRepo petRepo;

    public List<DoctorEntity> findAllBy() {
        return doctorRepo.findAll();
    }
    public DoctorEntity findById(Long id) throws DoctorException {
        return doctorRepo.findById(id).orElseThrow((()-> new DoctorException("doctor not found")));
    }
    public DoctorEntity create( DoctorEntity doctorEntity){
        return doctorRepo.save(doctorEntity);
    }

    public String delete( Long id){
        doctorRepo.deleteById(id);
        return "Success delete doctor : " + id;
    }

    public DoctorEntity createPet(PetEntity petEntity, Long id) throws DoctorException {
        DoctorEntity doctorEntity = doctorRepo.findById(id).orElseThrow((()-> new DoctorException("doctor not found"))); //+
        doctorEntity.addPet(petEntity);
        petEntity.setDoctor(doctorEntity); //+
        return doctorRepo.save(doctorEntity);
    }
    public DoctorEntity addPetInDoctor(Long doctorId, Long petId) throws DoctorException, PetException {
        DoctorEntity doctorEntity = doctorRepo.findById(doctorId).orElseThrow(() -> new DoctorException("doctor not found"));
        PetEntity petEntity = petRepo.findById(petId).orElseThrow(()-> new PetException("pet not found"));
//        doctorEntity.addPet(petEntity);
        petEntity.setDoctor(doctorEntity);
        return doctorRepo.save(doctorEntity);
    }
}
