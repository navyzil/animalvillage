package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class RenderLunchTimeHelperTest {
    private List<Animal> animals;
    private Map<String,  List<Animal>> lunchBuddiesMap;

    @Before
    public void setUp(){
        animals = InitializationHelper.initializeAnimals();
        lunchBuddiesMap = InitializationHelper.initializeLunchBuddies(animals);
    }

    @Test
    public void shouldPrintLunchBuddiesOnConsole() {
        RenderLunchTimeHelper renderLunchTimeHelper = new RenderLunchTimeHelper();
        renderLunchTimeHelper.generateLunchMessage(lunchBuddiesMap);
    }

}
