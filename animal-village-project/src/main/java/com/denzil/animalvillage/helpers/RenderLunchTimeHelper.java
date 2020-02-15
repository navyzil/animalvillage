package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;

import java.util.List;
import java.util.Map;

public class RenderLunchTimeHelper {
    public void generateLunchMessage(Map<String, List<Animal>> lunchBuddiesMap) {
        System.out.println();
        System.out.println("Lunch Time!");
        System.out.println();
        lunchBuddiesMap.forEach((lunch, animals) -> {
            StringBuilder lunchMessageBuilder = new StringBuilder();
            for (int animalIndex = 0; animalIndex < animals.size(); animalIndex++) {
                int lastAnimalIndex = animals.size() - 1;
                lunchMessageBuilder.append(animals.get(animalIndex).getName())
                        .append(" ");
                if (animals.size() > 1 && animalIndex != lastAnimalIndex) {
                    lunchMessageBuilder.append("and")
                            .append(" ");
                }
            }
            lunchMessageBuilder.append("are eating ")
                    .append(lunch);
            System.out.println(lunchMessageBuilder);
            System.out.println();
        });
    }
}
