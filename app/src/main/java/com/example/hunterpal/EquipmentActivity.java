package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EquipmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
    }

    public void onWeaponsClick(View view){
        Intent intent = new Intent(this,WeaponList.class);
        startActivity(intent);
    }

    public void onCallersClick(View view){
        Intent intent = new Intent(this,CallerList.class);
        startActivity(intent);
    }

    public void onDecoysClick(View view){
        Intent intent = new Intent(this,DecoyList.class);
        startActivity(intent);
    }
}
