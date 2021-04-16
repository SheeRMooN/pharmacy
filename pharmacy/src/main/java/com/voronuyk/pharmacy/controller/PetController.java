package com.voronuyk.pharmacy.controller;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping()
    public List<PetEntity> findAllBy(){
        return petService.findAllBy();
    }

    @GetMapping("/{id}")
    public Optional<PetEntity> findById(@PathVariable Long id){
        return petService.findById(id);
    }
    @PostMapping("/post")
    public PetEntity create(@RequestBody PetEntity petEntity){
        return petService.createByEntity(petEntity);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return petService.deleteById(id);
    }
//    @PostMapping("/post/{id}")
//    public PetEntity creatPetWithDoctor(@RequestBody PetEntity petEntity, @PathVariable Long id){
//        return petService.createPet(petEntity, id);
//    }
//    @PostMapping("/post/{id}")
//    public PetEntity creatPetWithDoctor(@RequestBody DoctorEntity doctorEntity, @PathVariable Long petId){
//        return petService.addDoctor(doctorEntity, petId);
//    }
}
