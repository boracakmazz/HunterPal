package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class CallerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller_list);

        RecyclerView callerRecycler = findViewById(R.id.caller_recycler);
        View view = findViewById(R.id.callerList);


        String[] callerNames = new String[Caller.callers.length];
        for(int i = 0; i<callerNames.length; i++){
            callerNames[i] = Caller.callers[i].getCallerName();
        }

        int[] callerImage = new int[Caller.callers.length];
        for(int i = 0; i<callerImage.length; i++){
            callerImage[i] = Caller.callers[i].getImageID();
        }

        CallerListAdapter adapter = new CallerListAdapter(callerImage,callerNames);
        callerRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        callerRecycler.setLayoutManager(layoutManager);
    }
}
