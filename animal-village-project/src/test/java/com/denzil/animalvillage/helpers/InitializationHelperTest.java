package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import com.denzil.animalvillage.models.Dog;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class InitializationHelperTest {

    @Test
    public void shouldInitializeAnimalsWithRightBff(){
        List<Animal> animals = InitializationHelper.initializeAnimals();
        Dog rex = (Dog)animals.get(0);
        Assert.assertNotNull(rex);
        Assert.assertEquals(rex.getBff(),"Tom");
        List<Animal> rexFriendList = rex.getFriendList();

        Animal rexSelf = rexFriendList.get(0);
        Assert.assertEquals(rexSelf.getName(),rex.getName());
        boolean isRexFriendSelf = rexSelf.isFriend();
        Assert.assertTrue(isRexFriendSelf);

        Animal max = rexFriendList.get(1);
        Assert.assertEquals(max.getName(),"Max");
        Assert.assertFalse(max.isFriend());

        Animal tom = rexFriendList.get(2);
        Assert.assertEquals(tom.getName(),"Tom");
        Assert.assertTrue(tom.isFriend());
    }

    @Test
    public void shouldInitializeAnimalsWithRightLunchGroup(){
        List<Animal> animals = InitializationHelper.initializeAnimals();
        Map<String,  List<Animal>> lunchBuddiesMap = InitializationHelper.initializeLunchBuddies(animals);

        Dog rex = (Dog)animals.get(0);
        Assert.assertNotNull(rex);
        Assert.assertEquals(rex.getBff(),"Tom");
        List<Animal> rexFriendList = rex.getFriendList();

        Animal rexSelf = rexFriendList.get(0);
        Assert.assertEquals(rexSelf.getName(),rex.getName());
        boolean isRexFriendSelf = rexSelf.isFriend();
        Assert.assertTrue(isRexFriendSelf);

        Animal tom = rexFriendList.get(2);
        Assert.assertEquals(tom.getName(),"Tom");
        Assert.assertTrue(tom.isFriend());

        List<Animal> lunchBuddies = lunchBuddiesMap.get(rex.getFavoriteFood());
        int royalCaninCount = lunchBuddies.size();
        Assert.assertEquals(royalCaninCount, 2);

        String shouldBeRex = lunchBuddies.get(0).getName();
        Assert.assertEquals(shouldBeRex,rex.getName());
        String shouldBeTom = lunchBuddies.get(1).getName();
        Assert.assertEquals(shouldBeTom,tom.getName());

        List<Animal> lunchBuddiesMannaPro = lunchBuddiesMap.get("Manna Pro");
        int mannaProCount = lunchBuddiesMannaPro.size();
        Assert.assertEquals(mannaProCount, 3);
        String shouldBeLis = lunchBuddiesMannaPro.get(0).getName();
        Assert.assertEquals(shouldBeLis,"Lis");
        String shouldBeLua = lunchBuddiesMannaPro.get(1).getName();
        Assert.assertEquals(shouldBeLua,"Lua");
        String shouldBeBob = lunchBuddiesMannaPro.get(2).getName();
        Assert.assertEquals(shouldBeBob,"Bob");

    }
}
