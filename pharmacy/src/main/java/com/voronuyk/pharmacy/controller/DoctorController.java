package com.voronuyk.pharmacy.controller;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;



    @GetMapping
    public List<DoctorEntity> findAllBy(){
        return doctorService.findAllBy();
    }

    @GetMapping("/{id}")
    public Optional<DoctorEntity> getById(@PathVariable Long id){
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
    public String createPet(@RequestBody PetEntity petEntity, @PathVariable Long id){
        return doctorService.createPet(petEntity,id);
    }
    @GetMapping("/add/{id}/{id}")
    public DoctorEntity addPetInDoctor(@PathVariable Long doctorId, @PathVariable Long petId){
        return doctorService.addPetInDoctor(doctorId,petId);
    }
}
