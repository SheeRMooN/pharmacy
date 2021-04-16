package com.voronuyk.pharmacy.repository;

import com.voronuyk.pharmacy.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepo extends JpaRepository<PetEntity, Long> {

    List<PetEntity>findAllBy();
    List<PetEntity>findById(long id);
}
