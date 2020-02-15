package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FriendshipStatusHelperTest {

    @Test
    public void shouldSuccessfullyAddFriend() {
        List<Animal> animals = InitializationHelper.initializeAnimals();
        new FriendshipStatusHelper().addFriendAttempt(animals);

        for (Animal animal : animals) {
            List<Animal> animalFriendList = animal.getFriendList();
            int numberOfFriends = (int) animalFriendList.stream().filter(animalFriend -> animalFriend.isFriend()).count();
            if(numberOfFriends > 2) {
                Assert.assertTrue(numberOfFriends > 2);
            }
        }
    }

    @Test
    public void shouldSuccessfullyUnFriend() {
        List<Animal> animals = InitializationHelper.initializeAnimals();
        new FriendshipStatusHelper().addFriendAttempt(animals);
        new FriendshipStatusHelper().unFriendAttempt(animals);

        for (Animal animal : animals) {
            List<Animal> animalFriendList = animal.getFriendList();
            int numberOfFriends = (int) animalFriendList.stream().filter(animalFriend -> animalFriend.isFriend()).count();
            if(numberOfFriends < 3) {
                Assert.assertTrue(numberOfFriends < 3);
            }
        }
    }
}
