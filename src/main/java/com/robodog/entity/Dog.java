package com.robodog.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long dogId;
    private int age;
    private String name;
    private String breed;

    public Dog() {}

    public Dog(Long dogId, int age, String name, String breed) {
        this.dogId = dogId;
        this.age = age;
        this.name = name;
        this.breed = breed;
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
