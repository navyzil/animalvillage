package com.denzil.animalvillage;

import com.denzil.animalvillage.helpers.InitializationHelper;
import com.denzil.animalvillage.models.Animal;

import java.util.List;
import java.util.Map;

/**
 * Main Application Client
 *
 */
public class MainAppClient
{
    public static void main( String[] args )
    {
        System.out.println("Starting Animal Village Application...");

        List<Animal> animals = InitializationHelper.initializeAnimals();
        Map<String, List<Animal>> lunchBuddiesMap = InitializationHelper.initializeLunchBuddies(animals);

        System.out.println("Starting Animal Activity:");
        AnimalActivityScheduler animalActivityScheduler = new AnimalActivityScheduler();
        animalActivityScheduler.startActivity(animals, lunchBuddiesMap);

        System.out.println("Thank You For Using Animal Village Application");
        System.out.println("Terminating App...");
    }
}
