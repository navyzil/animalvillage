package com.denzil.animalvillage;

import com.denzil.animalvillage.helpers.InitializationHelper;
import com.denzil.animalvillage.models.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class AnimalActivitySchedulerTest {
    private List<Animal> animals;
    private Map<String,  List<Animal>> lunchBuddiesMap;

    @Before
    public void setUp(){
        animals = InitializationHelper.initializeAnimals();
        lunchBuddiesMap = InitializationHelper.initializeLunchBuddies(animals);
    }

    @Test
    public void shouldDisplayAnimalActivityInConsole() {
        AnimalActivityScheduler animalActivityScheduler = new AnimalActivityScheduler();
        animalActivityScheduler.startActivity(animals, lunchBuddiesMap);
    }
}
