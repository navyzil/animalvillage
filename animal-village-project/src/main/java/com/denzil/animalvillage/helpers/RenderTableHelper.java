package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import com.denzil.animalvillage.utils.FriendshipTableMarkerUtil;

import java.util.List;

public class RenderTableHelper {
    public void renderTable(List<Animal> animalList) {
        int row = 16;
        int col = 29;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == 15) {
                    System.out.print(" -");
                }
                else if (i != 0 && j % 2 == 0) {
                    System.out.print("|");
                }
                else if (i == 1 && j == 1) {
                    System.out.print("   ");
                }
                else if (i == 1 && j != 1 && j % 2 == 1) {
                    int animalIndex = j - 3;
                    if(j > 3){
                        animalIndex = (j - 3) / 2;
                    }
                    Animal animal = animalList.get(animalIndex);
                    System.out.print(animal.getName());
                }
                else if (i != 0 && i != 1 && j == 1) {
                    if(i < row){
                        int animalIndex = i - 2;
                        Animal animal = animalList.get(animalIndex);
                        System.out.print(animal.getName());
                    }
                }
                else if(i >= 2 && j != 1 && j % 2 != 0){
                    int animalIndex = i - 2;
                    int animalFriendIndex = j - 3;
                    if(j != 3){
                        animalFriendIndex = (j - 3) / 2;
                    }
                    if(animalIndex < animalList.size()) {
                        Animal animal = animalList.get(animalIndex);
                        String friendshipMarker = FriendshipTableMarkerUtil.generateFriendshipMarker(animal, animalFriendIndex);
                        System.out.print(friendshipMarker);
                    }
                }
            }
            System.out.println();
        }
    }
}
