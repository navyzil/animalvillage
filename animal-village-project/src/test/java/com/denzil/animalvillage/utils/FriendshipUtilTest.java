package com.denzil.animalvillage.utils;

import com.denzil.animalvillage.helpers.InitializationHelper;
import com.denzil.animalvillage.models.Animal;
import com.denzil.animalvillage.models.Dog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FriendshipUtilTest {
    List<Animal> animals;

    @Before
    public void setup(){
        animals = InitializationHelper.initializeAnimals();
        Dog rex = (Dog)animals.get(0);
        Assert.assertNotNull(rex);
        Assert.assertEquals(rex.getBff(),"Tom");
        FriendshipUtil.gainFriendRoll(rex);
    }

    @Test
    public void shouldGainFriend(){
        Dog rex = (Dog)animals.get(0);
        Assert.assertNotNull(rex);
        Assert.assertEquals(rex.getBff(),"Tom");
        FriendshipUtil.gainFriendRoll(rex);

        List<Animal> rexFriendList = rex.getFriendList();

        for (Animal animalFriend : rexFriendList) {
            if(animalFriend.getId() == rex.getId()){
                Assert.assertTrue(animalFriend.isFriend());
            }
            else if(animalFriend.getName() == rex.getBff()){
                Assert.assertTrue(animalFriend.isFriend());
            }
            else if(animalFriend.isFriend()){
                Assert.assertTrue(animalFriend.isFriend());
            }
        }
    }

    @Test
    public void shouldLoseFriend(){
        Dog rex = (Dog)animals.get(0);
        Assert.assertNotNull(rex);
        Assert.assertEquals(rex.getBff(),"Tom");
        FriendshipUtil.loseFriendRoll(rex);

        List<Animal> rexFriendList = rex.getFriendList();

        for (Animal animalFriend : rexFriendList) {
            if(animalFriend.getId() == rex.getId()){
                Assert.assertTrue(animalFriend.isFriend());
            }
            else if(animalFriend.getName() == rex.getBff()){
                Assert.assertTrue(animalFriend.isFriend());
            }
            else if(!animalFriend.isFriend()){
                Assert.assertTrue(!animalFriend.isFriend());
            }
        }
    }
}
