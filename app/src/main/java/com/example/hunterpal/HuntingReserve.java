package com.example.hunterpal;

public class HuntingReserve {
    private int imageID;
    private String reserveName;
    private String country;
    private String habitants;
    private String vegetationCover;

    public HuntingReserve(int imageID,String reserveName, String country, String habitants, String vegetationCover) {
        this.imageID = imageID;
        this.reserveName = reserveName;
        this.country = country;
        this.habitants = habitants;
        this.vegetationCover = vegetationCover;
    }

    public static final HuntingReserve[] reserves = {
        new HuntingReserve(R.drawable.hirschfilden,"Hirschfilden","Germany","Red Fox, Red Deer, European Bison, Fallow Deer, Roe Deer, Wild Boar","Mixed Forests"),
        new HuntingReserve(R.drawable.yukon,"Yukon Valley","Canada","Harlequin Duck, Red Fox, Gray Wolf, Caribou, Grizzly Bear, Moose, Plains Bison","Snowy mountain forests, Pine forests"),
        new HuntingReserve(R.drawable.layton,"Layton Lake District","United States of America","Jackrabbit, Mallard Duck, Coyote, Blacktail Deer, Whitetail Deer, Black Bear, Roosevelt Elk, Moose","Mixed forests with lakes"),
        new HuntingReserve(R.drawable.savannah,"Bushveld","South Africa","Scrub Hare, Side-Striped Jackal, Springbok, Warthog, Lesser Kudu, Blue Wildebeast, Gemsbok, Cape Buffalo, Lion","Savannah with short bushes")
    };

    public int getImageID() {
        return imageID;
    }

    public String getReserveName(){
        return reserveName;
    }

    public String getCountry() {
        return country;
    }

    public String getHabitants() {
        return habitants;
    }

    public String getVegetationCover() {
        return vegetationCover;
    }
}
