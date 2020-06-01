package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class AnimalList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);
        RecyclerView animalRecycler = findViewById(R.id.animal_recycler);

        View view = findViewById(R.id.animalList);



        Snackbar.make(view,R.string.see_animal_detail,Snackbar.LENGTH_SHORT).show();

        String[] animalNames = new String[Animal.weapons.length];
        for(int i = 0; i<animalNames.length; i++){
            animalNames[i] = Animal.weapons[i].getAnimalName();
        }

        int[] animalImage = new int[Animal.weapons.length];
        for(int i = 0; i<animalImage.length; i++){
            animalImage[i] = Animal.weapons[i].getImageID();
        }

        AnimalListAdapter adapter = new AnimalListAdapter(animalImage,animalNames);
        animalRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        animalRecycler.setLayoutManager(layoutManager);

    }


}
