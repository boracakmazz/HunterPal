package com.example.hunterpal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {

    private String[] animalName;
    private int[] animalImage;

    private Listener listener;

    public AnimalListAdapter(int[] animalImage, String[] animalName){
        this.animalName = animalName;
        this.animalImage = animalImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_card_view,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.animal_card_picture);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(),animalImage[position]);

        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(animalName[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.animal_card_name);
        textView.setText(animalName[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(position);
                }
                Intent intent = new Intent(cardView.getContext(), AnimalDetail.class);
                intent.putExtra(AnimalDetail.EXTRA_ANIMAL_ID,position);
                cardView.getContext().startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount(){
        return animalName.length;
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
