package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ReserveList extends AppCompatActivity implements HuntingReserveList.Listener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_list);

    }

    public void itemClicked(long id){
        Intent intent = new Intent(this,HuntingReserveDetailActivity.class);
        intent.putExtra(HuntingReserveDetailActivity.EXTRA_RESERVE_ID,(int)id);
        startActivity(intent);
    }



}
