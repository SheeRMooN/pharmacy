package com.voronuyk.pharmacy.repository;

import com.voronuyk.pharmacy.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<DoctorEntity, Long> {

    List<DoctorEntity>findAllBy();
    List<DoctorEntity>findById(long id);
}
