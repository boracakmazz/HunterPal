package com.example.hunterpal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DecoyDetail extends AppCompatActivity {
    public static final String EXTRA_DECOY_ID = "decoyId";
    private BottomNavigationView bottom_navigation;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoy_detail);

        int decoyId = (Integer) getIntent().getExtras().get(EXTRA_DECOY_ID);


        setBottom_navigation();

        String decoyName = Decoy.decoys[decoyId].getDecoyName();
        TextView textView = findViewById(R.id.decoy_name);
        textView.setText(decoyName);

        int decoyImage = Decoy.decoys[decoyId].getImageID();
        ImageView imageView = findViewById(R.id.decoy_photo);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, decoyImage));
        imageView.setContentDescription(decoyName);

        String decoyPrice = Decoy.decoys[decoyId].getPrice();
        TextView textViewBehaviour = findViewById(R.id.decoy_price);
        textViewBehaviour.setText(decoyPrice);

        String usedAnimals = Decoy.decoys[decoyId].getUsedAnimals();
        TextView textViewAnimals = findViewById(R.id.decoy_recommended_animals);
        textViewAnimals.setText(usedAnimals);
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
