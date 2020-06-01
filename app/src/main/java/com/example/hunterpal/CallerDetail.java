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

public class CallerDetail extends AppCompatActivity {
    public static final String EXTRA_CALLER_ID = "callerId";
    private BottomNavigationView bottom_navigation;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller_detail);

        int callerId = (Integer) getIntent().getExtras().get(EXTRA_CALLER_ID);


        setBottom_navigation();



        String callerName = Caller.callers[callerId].getCallerName();
        TextView textView = findViewById(R.id.caller_name);
        textView.setText(callerName);

        int callerImage = Caller.callers[callerId].getImageID();
        ImageView imageView = findViewById(R.id.callerPhoto);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, callerImage));
        imageView.setContentDescription(callerName);

        String callerPrice = Caller.callers[callerId].getPrice();
        TextView textViewBehaviour = findViewById(R.id.caller_price);
        textViewBehaviour.setText(callerPrice);

        String usedAnimals = Caller.callers[callerId].getUsedAnimals();
        TextView textViewAnimals = findViewById(R.id.caller_recommended_animals);
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



