package com.denzil.animalvillage.utils;

import com.denzil.animalvillage.models.Animal;

public class FriendshipUtil {
    public static void gainFriendRoll(Animal animal) {
        int animalFriendId = animalFriendRoll();
        for (Animal animalFriend : animal.getFriendList()) {
            if (animalFriendId == animalFriend.getId()) {
                if (animalFriend.isFriend()) {
                    animalFriendId = animalFriendRoll();
                    continue;
                }
                animalFriend.setFriend(true);
            }
        }
    }

    public static void loseFriendRoll(Animal animal) {
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
                }
            }
        }
    }

    private static int animalFriendRoll() {
        return (int) (Math.random() * ((13 - 1) + 1)) + 1;
    }
}
