package com.example.hunterpal;

public class Caller {
    private int ImageID;
    private String callerName;
    private String price;
    private String usedAnimals;

    public Caller(int imageID, String callerName, String price, String usedAnimals) {
        ImageID = imageID;
        this.callerName = callerName;
        this.price = price;
        this.usedAnimals = usedAnimals;
    }

    public static final Caller[] callers = {
        new Caller(R.drawable.hog_caller,"Wild boar & Warthog caller","25$ - 50$","Wild boar, Warthog"),
        new Caller(R.drawable.distressed_fawn_caller, "Predator Distressed Fawn Caller","100$ - 150$","Lion, Black bear, Grizzly bear, Puma, Red fox, Gray wolf, Coyote"),
        new Caller(R.drawable.moose_caller,"Moose caller","40$ - 100$", "Moose"),
        new Caller(R.drawable.roosevelt_elk_caller,"Roosevelt elk caller","60$ - 200$","Roosevelt Elk"),
        new Caller(R.drawable.deer_caller,"Deer caller","20$ - 100$","Whitetail deer, Blacktail deer, Caribou, Roe deer, Axis deer"),
        new Caller(R.drawable.rabbit_caller,"Rabbit caller","20$ - 60$", "Jackrabbit, Wild hare")
    };

    public int getImageID() {
        return ImageID;
    }

    public String getCallerName() {
        return callerName;
    }

    public String getPrice() {
        return price;
    }

    public String getUsedAnimals() {
        return usedAnimals;
    }
}
