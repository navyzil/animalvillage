package com.denzil.animalvillage.models;

import java.util.List;

public class Animal implements Cloneable{
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

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getBff() {
        return bff;
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

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
