package com.voronuyk.pharmacy.controller;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.exception.DoctorException;
import com.voronuyk.pharmacy.exception.PetException;
import com.voronuyk.pharmacy.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {
    DoctorService doctorService;

    @GetMapping
    public List<DoctorEntity> findAllBy(){
        return doctorService.findAllBy();
    }

    @GetMapping("/{id}")
    public DoctorEntity getById(@PathVariable Long id) throws DoctorException {
        return doctorService.findById(id);
    }
    @PostMapping("/post")
    public DoctorEntity createDoctor(@RequestBody DoctorEntity doctorEntity){
        return doctorService.create(doctorEntity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return doctorService.delete(id);
    }

    @PostMapping("/post/{id}")
    public DoctorEntity createPet(@RequestBody PetEntity petEntity, @PathVariable Long id) throws DoctorException {
        return doctorService.createPet(petEntity,id);
    }
    @GetMapping("/add/{doctorId}/{petId}")
    public DoctorEntity addPetInDoctor(@PathVariable Long doctorId, @PathVariable Long petId) throws DoctorException, PetException {
        return doctorService.addPetInDoctor(doctorId,petId);
    }
}
