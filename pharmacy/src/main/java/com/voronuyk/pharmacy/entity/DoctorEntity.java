package com.voronuyk.pharmacy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<PetEntity> pets = new LinkedList<>();

    public void addPet(PetEntity petEntity){
        pets.add(petEntity);
    }


}
