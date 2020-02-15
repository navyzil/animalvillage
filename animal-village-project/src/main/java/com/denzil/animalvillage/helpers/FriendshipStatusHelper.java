package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import com.denzil.animalvillage.utils.FriendshipUtil;

import java.util.List;

public class FriendshipStatusHelper {
    public void addFriendAttempt(List<Animal> animalList) {
        animalList.forEach(animal -> {
            int animalFriendCount = getAnimalFriendCount(animal);
            FriendshipUtil.gainFriendRoll(animal, animalFriendCount);
        });
    }

    public void unFriendAttempt(List<Animal> animalList) {
        animalList.forEach(animal -> {
            int animalFriendCount = getAnimalFriendCount(animal);
            FriendshipUtil.loseFriendRoll(animal, animalFriendCount);
        });
    }

    private int getAnimalFriendCount(Animal animal) {
        List<Animal> friendList = animal.getFriendList();
        return (int) friendList.stream()
                .filter(animalFriend -> animalFriend.isFriend())
                .count();
    }
}
