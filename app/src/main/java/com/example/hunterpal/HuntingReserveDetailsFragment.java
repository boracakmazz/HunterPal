package com.example.hunterpal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HuntingReserveDetailsFragment extends Fragment {

    private long reserveID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_hunting_reserve_details_fragment,container,false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view !=null){
            HuntingReserve reserve = HuntingReserve.reserves[(int)reserveID];
            ImageView imageView = view.findViewById(R.id.landscape);
            imageView.setImageResource(reserve.getImageID());

            TextView reserveName = (TextView) view.findViewById(R.id.reserveName);
            reserveName.setText(reserve.getReserveName());

            TextView countryName = (TextView) view.findViewById(R.id.countryName);
            countryName.setText(reserve.getCountry());

            TextView habitants = (TextView) view.findViewById(R.id.habitants);
            habitants.setText(reserve.getHabitants());

            TextView vegetationCover = (TextView) view.findViewById(R.id.vegetationCover);
            vegetationCover.setText(reserve.getVegetationCover());
        }
    }

    public void setReserve(long id){
        this.reserveID = id;
    }
}
