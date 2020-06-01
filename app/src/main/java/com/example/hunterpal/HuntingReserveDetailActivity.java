package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HuntingReserveDetailActivity extends AppCompatActivity {
    public static final String EXTRA_RESERVE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunting_reserve_detail);
        HuntingReserveDetailsFragment fragment = (HuntingReserveDetailsFragment)
                getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        int reserveID = (int) getIntent().getExtras().get(EXTRA_RESERVE_ID);
        fragment.setReserve(reserveID);
    }
}
