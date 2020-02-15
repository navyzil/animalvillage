package com.denzil.animalvillage;

import com.denzil.animalvillage.helpers.FriendshipStatusHelper;
import com.denzil.animalvillage.helpers.RenderLunchTimeHelper;
import com.denzil.animalvillage.helpers.RenderTableHelper;
import com.denzil.animalvillage.models.Animal;

import java.util.List;
import java.util.Map;

public class AnimalActivityScheduler {
    public void startActivity(List<Animal> animalList, Map<String,  List<Animal>> lunchBuddiesMap){
        FriendshipStatusHelper friendshipStatusHelper = new FriendshipStatusHelper();
        RenderLunchTimeHelper renderLunchTimeHelper = new RenderLunchTimeHelper();
        RenderTableHelper renderTableHelper = new RenderTableHelper();

        for(int day = 1; day <= 10 ; day++){
            System.out.println("Day-"+day);
            for(int hour = 0; hour < 24; hour++){
                if(hour < 12){
                    System.out.println("Animals unfriend events(Time:" + hour + ":00-" + hour + ":59)");
                    friendshipStatusHelper.unFriendAttempt(animalList);
                    System.out.println();

                }
                else if(hour == 12){
                    System.out.println();
                    System.out.println();

                    System.out.println("Animals lunch events(Time:" + hour + ":00-" + hour + ":59)");
                    renderLunchTimeHelper.generateLunchMessage(lunchBuddiesMap);
                    System.out.println();
                }
                else if(hour >= 13 && hour < 23){
                    System.out.println();
                    System.out.println();

                    System.out.println("Animals add friend events(Time:" + hour + ":00-" + hour + ":59)");
                    friendshipStatusHelper.addFriendAttempt(animalList);
                    System.out.println();
                }
                else if(hour == 23){
                    System.out.println();
                    System.out.println();

                    System.out.println("End of Day-" + day);
                    System.out.println("Friendship Table for Day-" + day);
                    renderTableHelper.renderTable(animalList);
                    System.out.println();
                }
            }
        }
    }
}
