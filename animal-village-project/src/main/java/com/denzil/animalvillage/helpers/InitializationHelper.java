package com.denzil.animalvillage.helpers;

import com.denzil.animalvillage.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitializationHelper {

    public static List<Animal> initializeAnimals(){
        Dog rex = new Dog(1, "Rex","Shepered", "Royal Canin","Tom");
        Dog max = new Dog(2, "Max","Shepered", "Purina ONE","Jay");
        Dog tom = new Dog(3, "Tom","Husky", "Royal Canin","Rex");
        Dog jay = new Dog(4, "Jay","Husky", "Purina ONE","Max");
        Cat zoe = new Cat(5, "Zoe","9Lives","Ada");
        Cat ada = new Cat(6, "Ada","Purina Friskies", "Zoe");
        Chicken meg = new Chicken(7, "Meg","Purina Layena",true, "0.4m","Lis");
        Chicken lis = new Chicken(8, "Lis","Manna Pro",true, "0.35m","Meg");
        Chicken emi = new Chicken(9, "Emi","Purina Layena",false, "0.25m","Lua");
        Chicken lua = new Chicken(10, "Lua","Manna Pro",false, "0.3m","Emi");
        Rooster bob = new Rooster(11, "Bob","Manna Pro", "0.5m");
        Parrot mac = new Parrot(12, "Mac","Lafeber Original", "0.33m",true, "Alf");
        Parrot alf = new Parrot(12, "Alf","Kaytee Fiesta", "0.25m",false, "Mac");


        ArrayList<Animal> animalList = new ArrayList<Animal>();
        animalList.add(rex);
        animalList.add(max);
        animalList.add(tom);
        animalList.add(jay);
        animalList.add(zoe);
        animalList.add(ada);
        animalList.add(meg);
        animalList.add(lis);
        animalList.add(emi);
        animalList.add(lua);
        animalList.add(bob);
        animalList.add(mac);
        animalList.add(alf);

        initializeFriendship(animalList);

        return animalList;
    }

    public static Map<String,  List<Animal>> initializeLunchBuddies(List<Animal> animalList){
        Map<String,  List<Animal>> lunchBuddyMap = new HashMap<>();
        List<Animal> royalCaninGroupList = new ArrayList<>();
        List<Animal> purinaOneGroupList = new ArrayList<>();
        List<Animal> nineLivesGroupList = new ArrayList<>();
        List<Animal> purinaFirskiesGroupList = new ArrayList<>();
        List<Animal> purinaLayenaGroupList = new ArrayList<>();
        List<Animal> mannaProGroupList = new ArrayList<>();
        List<Animal> lafeberOriginalGroupList = new ArrayList<>();
        List<Animal> kayteeFiestaGroupList = new ArrayList<>();

        for (Animal animal : animalList) {
            switch (animal.getFavoriteFood()){
                case "Royal Canin":
                    royalCaninGroupList.add(animal);
                break;
                case "Purina ONE": purinaOneGroupList.add(animal);

                    break;
                case "9Lives": nineLivesGroupList.add(animal);
                    break;
                case "Purina Friskies": purinaFirskiesGroupList.add(animal);
                    break;
                case "Purina Layena": purinaLayenaGroupList.add(animal);
                    break;
                case "Manna Pro": mannaProGroupList.add(animal);
                    break;
                case "Lafeber Original": lafeberOriginalGroupList.add(animal);
                    break;
                case "Kaytee Fiesta": kayteeFiestaGroupList.add(animal);
                    break;
                default: throw new RuntimeException("Unmatched Food");
            }
        }
        lunchBuddyMap.put("Royal Canin",royalCaninGroupList);
        lunchBuddyMap.put("Purina ONE",purinaOneGroupList);
        lunchBuddyMap.put("9Lives",nineLivesGroupList);
        lunchBuddyMap.put("Purina Friskies",purinaFirskiesGroupList);
        lunchBuddyMap.put("Purina Layena",purinaLayenaGroupList);
        lunchBuddyMap.put("Manna Pro",mannaProGroupList);
        lunchBuddyMap.put("Lafeber Original",lafeberOriginalGroupList);
        lunchBuddyMap.put("Kaytee Fiesta",kayteeFiestaGroupList);

        return lunchBuddyMap;
    }


    private static void initializeFriendship(ArrayList<Animal> animalList) {
        for(Animal animal:animalList){
            animal.setFriendList(initializeShallowCopyAnimals());
            for(Animal animalFriend:animal.getFriendList()){
                if(animal.getId() == animalFriend.getId()){
                    animalFriend.setFriend(true);
                }
                else if(animal.getBff()!=null && animal.getBff().equals(animalFriend.getName())){
                    animalFriend.setFriend(true);
                }
            }
        }
    }

    /**
     * Shallow copy is created to prevent overwriting of friendship flags among animals
     * @return List<Animal> list of Shallow copy of Animal classes
     */
    private static List<Animal> initializeShallowCopyAnimals(){
        Dog rex = new Dog(1, "Rex","Shepered", "Royal Canin","Tom");
        Dog max = new Dog(2, "Max","Shepered", "Purina ONE","Jay");
        Dog tom = new Dog(3, "Tom","Husky", "Royal Canin","Rex");
        Dog jay = new Dog(4, "Jay","Husky", "Purina ONE","Max");
        Cat zoe = new Cat(5, "Zoe","9Lives","Ada");
        Cat ada = new Cat(6, "Ada","Purina Friskies", "Zoe");
        Chicken meg = new Chicken(7, "Meg","Purina Layena",true, "0.4m","Lis");
        Chicken lis = new Chicken(8, "Lis","Manna Pro",true, "0.35m","Meg");
        Chicken emi = new Chicken(9, "Emi","Purina Layena",false, "0.25m","Lua");
        Chicken lua = new Chicken(10, "Lua","Manna Pro",false, "0.3m","Emi");
        Rooster bob = new Rooster(11, "Bob","Manna Pro", "0.5m");
        Parrot mac = new Parrot(12, "Mac","Lafeber Original", "0.33m",true, "Alf");
        Parrot alf = new Parrot(12, "Alf","Kaytee Fiesta", "0.25m",false, "Mac");


        ArrayList<Animal> animalList = new ArrayList<Animal>();
        animalList.add(rex);
        animalList.add(max);
        animalList.add(tom);
        animalList.add(jay);
        animalList.add(zoe);
        animalList.add(ada);
        animalList.add(meg);
        animalList.add(lis);
        animalList.add(emi);
        animalList.add(lua);
        animalList.add(bob);
        animalList.add(mac);
        animalList.add(alf);
        return animalList;
    }

}
