package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class DecoyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoy_list);

        RecyclerView decoyRecycler = findViewById(R.id.decoy_recycler);
        View view = findViewById(R.id.decoyList);

        String[] decoyNames = new String[Decoy.decoys.length];
        for(int i = 0; i<decoyNames.length; i++){
            decoyNames[i] = Decoy.decoys[i].getDecoyName();
        }

        int[] decoyImage = new int[Decoy.decoys.length];
        for(int i = 0; i<decoyImage.length; i++){
            decoyImage[i] = Decoy.decoys[i].getImageID();
        }

        DecoyListAdapter adapter = new DecoyListAdapter(decoyImage,decoyNames);
        decoyRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        decoyRecycler.setLayoutManager(layoutManager);
    }
}



