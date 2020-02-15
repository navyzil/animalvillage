package com.denzil.animalvillage.models;

import java.util.List;

public class Animal {
    private int id;
    private String name;
    private String favoriteFood;
    private String bff;
    private boolean isFriend;
    private List<Animal> friendList;

    public Animal(int id, String name,  String favoriteFood, String bff) {
        this.id = id;
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.bff = bff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getBff() {
        return bff;
    }

    public void setBff(String bff) {
        this.bff = bff;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    public List<Animal> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Animal> friendList) {
        this.friendList = friendList;
    }
}
