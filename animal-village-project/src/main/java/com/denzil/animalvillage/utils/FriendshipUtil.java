package com.denzil.animalvillage.utils;

import com.denzil.animalvillage.models.Animal;

public class FriendshipUtil {
    public static void gainFriendRoll(Animal animal, int animalFriendCount) {
        int probabilty = friendUnfriendProbabiltyRoll();
        if(animalFriendCount <= 2) {
            if (probabilty < 90) {
                gainFriendAttemptRoll(animal);
            }
        }
        if(probabilty >= 90){
            gainFriendAttemptRoll(animal);
        }
    }

    public static void loseFriendRoll(Animal animal, int animalFriendCount) {
        int probabilty = friendUnfriendProbabiltyRoll();
        if(animalFriendCount >= 3) {
            if (probabilty < 90) {
                unfriendAttemptRoll(animal);
            }
        }
        if(probabilty >= 90){
            unfriendAttemptRoll(animal);
        }
    }

    private static void unfriendAttemptRoll(Animal animal) {
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
                    System.out.println(animal.getName()+ " and " +animalFriend.getName()+ " are not friends anymore.");
                }
            }
        }
    }

    private static void gainFriendAttemptRoll(Animal animal) {
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
                System.out.println(animal.getName() + " and " + animalFriend.getName() + " are friends now.");
                continue;
            }
            if (animal.getName() != animalFriend.getName() && animal.getBff() != animalFriend.getName()) {
                System.out.println(animalFriend.getName() + " doesn't want to be friends");
            }
        }
    }

    private static int animalFriendRoll() {
        return (int) (Math.random() * ((13 - 1) + 1)) + 1;
    }

    private static int friendUnfriendProbabiltyRoll(){
        return (int)(Math.random() * 100);
    }
}
