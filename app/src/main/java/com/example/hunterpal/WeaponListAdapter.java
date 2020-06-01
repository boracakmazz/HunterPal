package com.example.hunterpal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class WeaponListAdapter extends RecyclerView.Adapter<WeaponListAdapter.ViewHolder> {

    private String[] weaponName;
    private int[] weaponImage;

    private WeaponListAdapter.Listener listener;

    public WeaponListAdapter(int[] weaponImage, String[] weaponName){
        this.weaponName = weaponName;
        this.weaponImage = weaponImage;
    }

    @NonNull
    @Override
    public WeaponListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.weapon_card_view,parent,false);
        return new WeaponListAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull WeaponListAdapter.ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.weapon_card_picture);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), weaponImage[position]);

        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(weaponName[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.weapon_card_name);
        textView.setText(weaponName[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(position);
                }
                Intent intent = new Intent(cardView.getContext(), WeaponDetail.class);
                intent.putExtra(WeaponDetail.EXTRA_WEAPON_ID,position);
                cardView.getContext().startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount(){
        return weaponName.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }
    }

    interface Listener{
        void onClick(int position);
    }
}
