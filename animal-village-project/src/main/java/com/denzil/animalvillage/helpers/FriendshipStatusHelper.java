package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import com.denzil.animalvillage.utils.FriendshipUtil;

import java.util.List;

public class FriendshipStatusHelper {
    public void addFriendAttempt(List<Animal> animalList) {
        animalList.forEach(animal -> {
            int animalFriendCount = getAnimalFriendCount(animal);
            if(animalFriendCount<=2){
                int probabilty = friendUnfriendProbabiltyRoll();
                if(probabilty < 90){
                    FriendshipUtil.gainFriendRoll(animal);
                }
                else
                    FriendshipUtil.loseFriendRoll(animal);
            }
        });
    }

    public void unFriendAttempt(List<Animal> animalList) {
        animalList.forEach(animal -> {
            int animalFriendCount = getAnimalFriendCount(animal);
            if(animalFriendCount>=3){
                int probabilty = friendUnfriendProbabiltyRoll();
                if(probabilty < 90){
                    FriendshipUtil.loseFriendRoll(animal);
                }
                else
                    FriendshipUtil.gainFriendRoll(animal);
            }
        });
    }

    private int getAnimalFriendCount(Animal animal) {
        List<Animal> friendList = animal.getFriendList();
        return (int) friendList.stream()
                .filter(animalFriend -> animalFriend.isFriend())
                .count();
    }

    private int friendUnfriendProbabiltyRoll(){
        return (int)(Math.random()*100);
    }

}
