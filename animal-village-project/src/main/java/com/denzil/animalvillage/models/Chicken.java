package com.denzil.animalvillage.models;

public class Chicken extends Bird{
    private boolean isLayingEggs;

    public Chicken(int id, String name, String favoriteFood, boolean isLayingEggs, String wingspan, String bff) {
        super(id, name, favoriteFood, bff, wingspan);
        this.isLayingEggs = isLayingEggs;
    }

    public boolean isLayingEggs() {
        return isLayingEggs;
    }
}
