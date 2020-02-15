package com.denzil.animalvillage.models;

public class Parrot extends Bird{
    private boolean isTalking;

    public Parrot(int id, String name, String favoriteFood, String wingspan, boolean isTalking, String bff) {
        super(id, name, favoriteFood, bff, wingspan);
        this.isTalking = isTalking;
    }

    public boolean isTalking() {
        return isTalking;
    }
}
