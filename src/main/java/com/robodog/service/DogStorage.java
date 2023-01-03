package com.robodog.service;

import java.util.ArrayList;
import java.util.List;

import com.robodog.entity.Dog;
import org.springframework.stereotype.Service;

@Service
public class DogStorage implements DogService {
    private List<Dog> dogs = new ArrayList<>();

    public long getNextId() {
        if (dogs.isEmpty()) {
            return 1;
        } else {
            return dogs.get(dogs.size() - 1).getDogId() + 1;
        }
    }

    public void addDog(Dog dog) {
        dog.setDogId(getNextId());
        dogs.add(dog);
    }

    public void addRandomDog() {
        DogCreator dogCreator = new DogCreator();
        dogs.add(dogCreator.createRandomDog(getNextId()));
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void updateDog(Long dogId, String name, int age, String breed) {
        for (Dog dog : dogs) {
            if (dog.getDogId().equals(dogId)){
                dog.setName(name);
                dog.setAge(age);
                dog.setBreed(breed);
                break;
            }
        }
    }

    @Override
    public Dog getDog(Long dogId) {
        return this.dogs.stream().filter(Dog->Dog.getDogId().equals(dogId)).findAny().orElse(null);
    }
}
