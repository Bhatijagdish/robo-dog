package com.robodog.controller;

import com.robodog.entity.Dog;
import com.robodog.service.DogCreator;
import com.robodog.service.DogService;
import com.robodog.service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/robo-dog")
public class DogController {

    @Autowired
    private DogService dogService;
    private DogStorage dogStorage;
    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogStorage.getDogs();
    }

    @GetMapping("/random")
    public Dog getRandomDog() {
        dogStorage.addRandomDog();
        return dogStorage.getDogs().get(dogStorage.getDogs().size() - 1);
    }

    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        dog.setDogId(dogStorage.getNextId());
        dogStorage.addDog(dog);
        return dog;
    }

    @PutMapping("/{dogId}")
    public void updateDog(@PathVariable("dogId") Long dogId, @RequestBody Dog dog) {
        dogStorage.updateDog(dogId, dog.getName(), dog.getAge(), dog.getBreed());
    }

    @GetMapping("/{dogId}")
    public Dog getId(@PathVariable("dogId") Long dogId){
        return this.dogService.getDog(dogId);
    }
}
