package com.example.hunterpal;

public class Weapon {
    private int imageID;
    private String weaponName;
    private String price;
    private String magazine;
    private String cartridge;
    private String recommendedAnimals;

    public Weapon(int imageID, String weaponName, String price, String magazine, String cartridge, String recommendedAnimals) {
        this.imageID = imageID;
        this.weaponName = weaponName;
        this.price = price;
        this.magazine = magazine;
        this.cartridge = cartridge;
        this.recommendedAnimals = recommendedAnimals;
    }

    public static final Weapon[] weapons = {
            new Weapon(R.drawable.twenty_two_lr_rifle,"Virant .22LR","200$ - 400$","10",".22","Ducks, Goose, Turkey, Rabbits"),
            new Weapon(R.drawable.two_hundred_forty_rifle,"Ranger .243","200$ - 2500$","5",".243","Whitetail deer, Blacktail deer, Caribou, Gray wolf, Wild boar, Red fox, Coyote"),
            new Weapon(R.drawable.two_hundred_seventy_rifle,"Huntsman .270","500 - 1700$","4",".270","Whitetail deer, Blacktail deer, Caribou, Gray wolf, Red deer, Warthog, Wild boar, Gemsbok, Blue wildebeast, Roosevelt elk "),
            new Weapon(R.drawable.forty_seventy_marlin_rifle,".45 - 70 Marlin Repeater"," 450$ - 1500$","10",".45 - 70","Whitetail deer, Blacktail deer, Caribou, Gray wolf, Wild boar"),
            new Weapon(R.drawable.seven_milimeter_rifle,"7MM Magnum","500$ - 2500$","5","7MM","Black bear, Gray Wolf, Moose, Lion, Grizzly bear, European bison, Plains bison, Gemsbok, Blue wildebeast, Wild boar"),
            new Weapon(R.drawable.three_hundred_rifle,".300 Canning Magnum", "1000$ - 4500$","5",".300","Moose, Lion, Grizzly bear, European bison, Plains bison, Gemsbok, Blue wildebeast, Wild boar, Roosevelt Elk")

    };

    public int getImageID() {
        return imageID;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public String getPrice() {
        return price;
    }

    public String getMagazine() {
        return magazine;
    }

    public String getCartridge() {
        return cartridge;
    }

    public String getRecommendedAnimals() {
        return recommendedAnimals;
    }
}
