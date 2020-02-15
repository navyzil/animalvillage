package com.denzil.animalvillage.models;

public class Dog extends Animal{
    private String breed;
    public Dog(int id, String name, String breed, String favoriteFood, String bff) {
        super(id, name, favoriteFood, bff);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}
