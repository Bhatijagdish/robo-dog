package com.robodog.service;
import java.util.Random;
import com.robodog.entity.Dog;
import org.springframework.stereotype.Service;
@Service
public class DogCreator{

    public DogStorage dogStorage;
    private static final String[] NAMES = { "Fido", "Buddy", "Lucy", "Daisy", "Max" };
    private static final String[] BREEDS = { "Labrador", "Poodle", "Golden Retriever", "German Shepherd"};

    Random random = new Random();

    public Dog createRandomDog(Long dogId) {
        int age = random.nextInt(15)+1;
        String name = NAMES[random.nextInt(NAMES.length)];
        String breed = BREEDS[random.nextInt(BREEDS.length)];
        return new Dog(dogId, age, name, breed);
    }

}
