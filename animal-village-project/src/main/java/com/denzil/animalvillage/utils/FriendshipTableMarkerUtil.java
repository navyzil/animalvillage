package com.denzil.animalvillage.utils;

import com.denzil.animalvillage.models.Animal;

import java.util.List;

public class FriendshipTableMarkerUtil {
    public static String generateFriendshipMarker(Animal animal, int animalFriendListIndex){
        List<Animal> friendList = animal.getFriendList();
        Animal animalFriend = friendList.get(animalFriendListIndex);
        if(animalFriend.isFriend()){
            if(animalFriend.getId() == animal.getId()){
                return "/";
            }
            return "X";
        }
        return " ";
    }
}
