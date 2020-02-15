package com.denzil.animalvillage.models;

public class Bird extends Animal{
    private String wingspan;

    public Bird(int id, String name, String favoriteFood, String bff, String wingspan) {
        super(id, name, favoriteFood, bff);
        this.wingspan = wingspan;
    }

    public String getWingspan() {
        return wingspan;
    }
}

