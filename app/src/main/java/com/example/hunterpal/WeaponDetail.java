package com.example.hunterpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WeaponDetail extends AppCompatActivity {

    public static final String EXTRA_WEAPON_ID = "weaponId";
    private BottomNavigationView bottom_navigation;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_detail);

        int weaponId = (Integer) getIntent().getExtras().get(EXTRA_WEAPON_ID);

        setBottom_navigation();




        String weaponName = Weapon.weapons[weaponId].getWeaponName();
        TextView textView = findViewById(R.id.weapon_name);
        textView.setText(weaponName);

        int weaponImage = Weapon.weapons[weaponId].getImageID();
        ImageView imageView = findViewById(R.id.weapon_photo);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, weaponImage));
        imageView.setContentDescription(weaponName);

        String price = Weapon.weapons[weaponId].getPrice();
        TextView textViewBehaviour = findViewById(R.id.weapon_price);
        textViewBehaviour.setText(price);

        String magazine = Weapon.weapons[weaponId].getMagazine();
        TextView textViewHabitat = findViewById(R.id.weapon_magazine);
        textViewHabitat.setText(magazine);

        String cartridge = Weapon.weapons[weaponId].getCartridge();
        TextView textViewEquipment = findViewById(R.id.weapon_cartridge);
        textViewEquipment.setText(cartridge);

        String recommendedAnimals = Weapon.weapons[weaponId].getRecommendedAnimals();
        TextView textViewAnimals = findViewById(R.id.weapon_recommended_animals);
        textViewAnimals.setText(recommendedAnimals);

    }

    public void setBottom_navigation(){
        bottom_navigation = findViewById(R.id.bottom_navigation_weapons);

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

