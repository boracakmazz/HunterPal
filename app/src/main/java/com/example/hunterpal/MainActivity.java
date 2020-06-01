package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onHuntingReservesClick(View view){
        Intent intent = new Intent(this,ReserveList.class);
        startActivity(intent);
    }

    public void onWildlifeClick(View view){
        Intent intent = new Intent(this,AnimalList.class);
        startActivity(intent);

    }

    public void onEquipmentsClick(View view){
        Intent intent = new Intent(this,EquipmentActivity.class);
        startActivity(intent);
    }

    public void onNearestShopClick(View view){
        Intent intent = new Intent(this,NearestShop.class);
        startActivity(intent);
    }

    public void onContactClick(View view){  //implicit intent example
        Intent intent = new Intent(this,ContactActivity.class);
        startActivity(intent);
    }



}
