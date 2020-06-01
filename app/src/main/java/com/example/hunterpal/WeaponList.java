package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class WeaponList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_list);

        RecyclerView weaponRecycler = findViewById(R.id.weapon_recycler);

        View view = findViewById(R.id.weaponList);


        Snackbar.make(view,R.string.click_weapon_detail,Snackbar.LENGTH_SHORT).show();

        String[] weaponNames = new String[Weapon.weapons.length];
        for(int i = 0; i<weaponNames.length; i++){
            weaponNames[i] = Weapon.weapons[i].getWeaponName();
        }

        int[] weaponImage = new int[Weapon.weapons.length];
        for(int i = 0; i<weaponImage.length; i++){
            weaponImage[i] = Weapon.weapons[i].getImageID();
        }

        WeaponListAdapter adapter = new WeaponListAdapter(weaponImage,weaponNames);
        weaponRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        weaponRecycler.setLayoutManager(layoutManager);

    }

}

