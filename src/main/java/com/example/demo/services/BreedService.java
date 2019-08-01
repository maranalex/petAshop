package com.example.demo.services;

import com.example.demo.entities.Breed;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.repositories.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BreedService {
    private BreedRepository breedRepository;

    @Autowired
    public BreedService(BreedRepository breedRepository){
        this.breedRepository=breedRepository;
    }

    public Breed createBreed(String breedName){
        Breed createdBreed=Breed.builder().breedName(breedName).build();
        breedRepository.save(createdBreed);
        return createdBreed;
    }
    public Breed findBreed(int id){
        Optional<Breed> finded = breedRepository.findById(id);

        if(finded.isPresent())return finded.get();
        throw new CustomerNotFoundException("Breed",id);
    }
}
