package com.example.hunterpal;

public class Decoy {
    private int imageID;
    private String decoyName;
    private String price;
    private String usedAnimals;

    public Decoy(int imageID, String decoyName, String price, String usedAnimals) {
        this.imageID = imageID;
        this.decoyName = decoyName;
        this.price = price;
        this.usedAnimals = usedAnimals;
    }

    public static final Decoy[] decoys = {
        new Decoy(R.drawable.duck_decoy,"Duck decoy","55$ - 100$","Any type of Duck, Goose"),
        new Decoy(R.drawable.rabbit_decoys,"Rabbit decoy","20$ - 50$","Jackrabbit, Wild hare"),
        new Decoy(R.drawable.deer_decoy,"Deer decoy","50$ - 200$","Whitetail deer, Blacktail deer, Roosevelt elk, Axis deer, Roe deer, Red deer, Caribou"),
        new Decoy(R.drawable.boar_decoy,"Boar decoy","65$ - 120$","Wild boar, Warthog")
    };

    public int getImageID() {
        return imageID;
    }

    public String getDecoyName() {
        return decoyName;
    }

    public String getPrice() {
        return price;
    }

    public String getUsedAnimals() {
        return usedAnimals;
    }
}
