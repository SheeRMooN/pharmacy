package com.voronuyk.pharmacy.controller;

import com.voronuyk.pharmacy.entity.PetEntity;
import com.voronuyk.pharmacy.exception.PetException;
import com.voronuyk.pharmacy.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@AllArgsConstructor
public class PetController {
    PetService petService;

    @GetMapping()
    public List<PetEntity> findAllBy(){
        return petService.findAllBy();
    }

    @GetMapping("/{id}")
    public PetEntity findById(@PathVariable Long id) throws PetException {
        return petService.findById(id);
    }
    @PostMapping("/post")
    public PetEntity create(@RequestBody PetEntity petEntity){
        return petService.createByEntity(petEntity);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        petService.deleteById(id);
    }

}
