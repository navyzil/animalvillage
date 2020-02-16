package com.denzil.animalvillage.utils;

import com.denzil.animalvillage.models.Animal;

import java.util.List;

public class FriendshipUtil {
    public static void gainFriendRoll(Animal animal, int animalFriendCount, List<Animal> animalList) {
        int probabilty = friendUnfriendProbabiltyRoll();
        if(animalFriendCount <= 2) {
            if (probabilty < 90) {
                gainFriendAttemptRoll(animal, animalList);
            }
            return;
        }
        if(probabilty >= 90){
            gainFriendAttemptRoll(animal, animalList);
        }
    }

    public static void loseFriendRoll(Animal animal, int animalFriendCount, List<Animal> animalList) {
        int probabilty = friendUnfriendProbabiltyRoll();
        if(animalFriendCount >= 3) {
            if (probabilty < 90) {
                unfriendAttemptRoll(animal, animalList);
            }
            return;
        }
        if(probabilty >= 90){
            unfriendAttemptRoll(animal, animalList);
        }
    }

    private static void unfriendAttemptRoll(Animal animal, List<Animal> animalList) {
        int animalFriendId = animalFriendRoll();
        for (Animal animalFriend : animal.getFriendList()) {
            String animalFriendName = animalFriend.getName();
            String animalBff = animal.getBff();

            if (animalFriendId == animalFriend.getId()) {
                if (animalFriendId == animal.getId()) {
                    animalFriendId = animalFriendRoll();
                    continue;
                } else if (animalFriendName.equals(animalBff)) {
                    animalFriendId = animalFriendRoll();
                    continue;
                } else {
                    animalFriend.setFriend(false);
                    reflectFriendShipToOtherParty(animal, animalList, animalFriend, false);
                    System.out.println(animal.getName()+ " and " +animalFriend.getName()+ " are not friends anymore.");
                }
            }
        }
    }

    private static void gainFriendAttemptRoll(Animal animal, List<Animal> animalList) {
        int animalFriendId = animalFriendRoll();
        for (Animal animalFriend : animal.getFriendList()) {
            if (animal.getName() != animalFriend.getName() && animal.getBff() != animalFriend.getName()) {
                System.out.print(animal.getName() + " is asking " + animalFriend.getName() + " to be friends. ");
            }
            if (animalFriendId == animalFriend.getId()) {
                if (animalFriend.isFriend()) {
                    animalFriendId = animalFriendRoll();
                    continue;
                }
                animalFriend.setFriend(true);
                reflectFriendShipToOtherParty(animal, animalList, animalFriend, true);
                System.out.println(animal.getName() + " and " + animalFriend.getName() + " are friends now.");
                continue;
            }
            if (animal.getName() != animalFriend.getName() && animal.getBff() != animalFriend.getName()) {
                System.out.println(animalFriend.getName() + " doesn't want to be friends");
            }
        }
    }

    private static void reflectFriendShipToOtherParty(Animal animal, List<Animal> animalList, Animal animalFriend, boolean isFriends) {
        animalList.forEach(animalInMasterList -> {
            if (animalInMasterList.getId() == animalFriend.getId()) {
                List<Animal> friendList = animalInMasterList.getFriendList();
                friendList.forEach(animalInAnimalFriendList -> {
                    if (animalInAnimalFriendList.getId() == animal.getId()) {
                        animalInAnimalFriendList.setFriend(isFriends);
                    }
                });
            }
        });
    }

    private static int animalFriendRoll() {
        return (int) (Math.random() * ((13 - 1) + 1)) + 1;
    }

    private static int friendUnfriendProbabiltyRoll(){
        return (int)(Math.random() * 100);
    }
}
