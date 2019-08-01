package com.example.demo.services;

import com.example.demo.entities.Breed;
import com.example.demo.entities.Dog;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DogService {
    private DogRepository dogRepository;
    private BreedService breedService;
    @Autowired
    public DogService(DogRepository dogRepository,BreedService breedService){
        this.dogRepository=dogRepository;
        this.breedService=breedService;
    }

    public Dog createDog(String name,int age,String gender,boolean sterilized,int breedId){
        Breed breed=breedService.findBreed(breedId);
        Dog createdDog=Dog.builder().name(name)
                .age(age)
                .gender(gender)
                .sterilized(sterilized).breed(breed).build();
        dogRepository.save(createdDog);
        return createdDog;
    }

    public Dog findDog(int id){
        Optional<Dog> finded = dogRepository.findById(id);

        if(finded.isPresent())return finded.get();
        throw new CustomerNotFoundException("Dog",id);
    }
}
