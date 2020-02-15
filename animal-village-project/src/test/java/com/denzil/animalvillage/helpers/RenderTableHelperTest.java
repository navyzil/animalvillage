package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.Animal;
import com.denzil.animalvillage.models.Dog;
import com.denzil.animalvillage.utils.FriendshipUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RenderTableHelperTest {
    private List<Animal> animals;

    @Before
    public void setUp(){
        animals = InitializationHelper.initializeAnimals();
        Dog rex = (Dog)animals.get(0);
        Assert.assertNotNull(rex);
        Assert.assertEquals(rex.getBff(),"Tom");
        List<Animal> rexFriendList = rex.getFriendList();
        int numberOfFriends = (int) rexFriendList.stream().filter(animalFriend -> animalFriend.isFriend()).count();

        FriendshipUtil.gainFriendRoll(rex, numberOfFriends);
    }

    @Test
    public void shouldPrintTableOnConsole() {
        RenderTableHelper renderTableHelper = new RenderTableHelper();
        renderTableHelper.renderTable(animals);
    }
}
