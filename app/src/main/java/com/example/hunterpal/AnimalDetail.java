package com.example.hunterpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class AnimalDetail extends AppCompatActivity {

    public static final String EXTRA_ANIMAL_ID = "animalId";
    private BottomNavigationView bottom_navigation;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);
        int animalId = (Integer) getIntent().getExtras().get(EXTRA_ANIMAL_ID);



        setBottom_navigation();


        View view = findViewById(R.id.animalPhoto);

        Snackbar.make(view,R.string.click_sound_button,Snackbar.LENGTH_SHORT).show();

        String animalName = Animal.weapons[animalId].getAnimalName();
        TextView textView = findViewById(R.id.animal_name);
        textView.setText(animalName);

        int animalImage = Animal.weapons[animalId].getImageID();
        ImageView imageView = findViewById(R.id.animalPhoto);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, animalImage));
        imageView.setContentDescription(animalName);

        String animalBehaviour = Animal.weapons[animalId].getAnimalBehaviour();
        TextView textViewBehaviour = findViewById(R.id.animal_behaviour);
        textViewBehaviour.setText(animalBehaviour);

        String animalHabitat = Animal.weapons[animalId].getAnimalHabitat();
        TextView textViewHabitat = findViewById(R.id.animal_habitat);
        textViewHabitat.setText(animalHabitat);

        String animalEquipment = Animal.weapons[animalId].getNeededEquipment();
        TextView textViewEquipment = findViewById(R.id.needed_equipment);
        textViewEquipment.setText(animalEquipment);


    }

    public void onAnimalSoundClick(View view) {
        int animalId = (Integer) getIntent().getExtras().get(EXTRA_ANIMAL_ID);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, Animal.weapons[animalId].getSoundID());
        mediaPlayer.setVolume(5,5);
        mediaPlayer.start();

    }

    public void setBottom_navigation(){
        bottom_navigation = findViewById(R.id.bottom_navigation_wildlife_details);

        bottom_navigation.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.wildlife_navigation){
                    intent = new Intent(getApplicationContext(),AnimalList.class);
                }

                if(menuItem.getItemId() == R.id.equipments_navigation){
                    intent = new Intent(getApplicationContext(),EquipmentActivity.class);
                }

                if(menuItem.getItemId() == R.id.nearest_shop_navigation){
                    intent = new Intent(getApplicationContext(),NearestShop.class);
                }
                startActivity(intent);
            }
        });
    }
}
