package com.example.hunterpal;

public class Animal {
    private int imageID;
    private int soundID;
    private String animalName;
    private String animalBehaviour;
    private String animalHabitat;
    private String neededEquipment;


    public Animal(int imageID,int soundID, String animalName, String animalHabitat, String neededEquipment, String animalBehaviour) {
        this.imageID = imageID;
        this.soundID = soundID;
        this.animalName = animalName;
        this.animalHabitat = animalHabitat;
        this.neededEquipment = neededEquipment;
        this.animalBehaviour = animalBehaviour;
    }

    public static final Animal[] weapons = {
            new Animal(R.drawable.bison,R.raw.bison_sound,"European Bison(Bison bonasus)","Germany(Hirschfilden), Most of european countries",".300 Cartridge Rifles, 7MM Cartridge Rifles","Mature bulls move in separate herds from the cows and their young. They join during the late summer which is their breeding season. Bulls will compete with each other for females by ramming and butting each other."),

            new Animal(R.drawable.grizzly_bear,R.raw.bear_sound,"Grizzly Bear(Ursus arctos horribilis)","Canada(Yukon Valley), Most of the countries around world",".300 Cartridge Rifles, .375 Cartridge Rifles, 7MM Cartridge Rifles, Predator 'Distressed Fawn' Caller","Grizzly bears hibernate during the winter for 5 – 8 months and usually dig their dens on north-facing slopes to ensure good snow cover.\n" +
                    "\n" + "Grizzly bears make a loud roar if they are injured, however, they will normally warn other bears of danger by huffing or making chomping sounds with their teeth."),

            new Animal(R.drawable.lion,R.raw.lion_sound,"Lion(Felis Leo or Panthera Leo)","Middle and South Africa savannas",".300 Cartridge Rifles, 7MM Cartridge Rifles, Predator 'Distressed Fawn' Caller","Lions are primarily nocturnal (active at night) or crepuscular (becoming active at twilight or before sunset). Lions spend much of their time resting, often up to 20 hours per day. During periods of rest, lions have many opportunities for social behaviour. They gather and sleep in groups, rubbing their heads together and playing. All of these behaviours are good for reinforcing their social bonds."),

            new Animal(R.drawable.mallard_duck,R.raw.mallard_duck_sound,"Mallard Duck(Anas platyrhynchos)","Almost any body of freshwater across Asia, Europa, and North America.","12-gauge Shotgun, Duck decoys, Duck callers","Ducks keep clean by preening themselves. Ducks do this by putting their heads in funny positions and putting their beaks into their body. Ducks preen themselves very often."),

            new Animal(R.drawable.moose,R.raw.moose_sound,"Moose(Alces alces)","Forested areas where there is snow cover in the winter and nearby lakes, bogs, swamps, streams and ponds.",".300 Cartridge Rifles, 7MM Cartridge Rifles, Moose Caller","Moose are mostly diurnal animals. They are generally solitary with the strongest bonds being between mother and calf. You can tell when a moose might attack if the long hairs on its hump are raised and its ears are laid back. A moose may also lick its lips."),

            new Animal(R.drawable.red_fox,R.raw.red_fox_sound,"Red Fox(Vulpes vulpes)","Forests, grasslands, mountains, and deserts. They also adapt well to human environments such as farms, suburban areas, and even large communities.",".240 Cartridge Rifles, Predator 'Distressed Fawn' Caller","Socially, the fox communicates with body language and a variety of vocalizations. Its vocal range is quite large and its noises vary from a distinctive three-yip ‘lost call’ to a shriek reminiscent of a human scream. It also communicates with scent, marking food and territorial boundary lines with urine and faeces."),

            new Animal(R.drawable.roosevelt_elk,R.raw.roosevelt_elk_sound,"Roosevelt Elk(Olympic Elk or Cervus canadensis roosevelti)","Rain forests of the western Cascade Mountains, from northern California, Oregon, Washington, and into British Columbia",".300 Cartridge Rifles, Roosevelt Elk Caller","Typically they enjoy open lands where they can walk freely and graze on grasses, however they often prefer a mix of old growth stands and edge environments.  This provides cover from the weather and predators."),

            new Animal(R.drawable.wild_boar,R.raw.wild_boar_sound,"Wild Boar(Sus scrofa)","Grasslands, taiga, tropical rainforests, but they prefer life in deciduous forests.","minimum .270 Cartridge Rifles, Boar Caller","Wild boars live in groups called sounders. Sounders typically contain around 20 animals, usually nocturnal, foraging from dusk until dawn but with resting periods during both night and day."),

            new Animal(R.drawable.wolf,R.raw.wolf_sound,"Gray Wolf(Canis lupus)","The gray wolf lives today in a diverse range of environments, including tundra, mountain areas, woodlands, forests, grasslands and deserts.",".270 Cartridge Rifles, .30 Cartridge Rifles,  Predator 'Distressed Fawn' Caller", "Wolves are complex, highly intelligent animals who are caring, playful, and above all devoted to family. Wolves communicate, collaborate and share knowledge across generations. The older wolves, as more experienced hunters, share hunting strategies and techniques with younger wolves, passing down knowledge from one generation to the next, maintaining a culture unique to that pack. ")
    };


    public int getImageID() {
        return imageID;
    }

    public int getSoundID(){
        return soundID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalBehaviour(){
        return animalBehaviour;
    }

    public String getAnimalHabitat() {
        return animalHabitat;
    }

    public String getNeededEquipment() {
        return neededEquipment;
    }
}
