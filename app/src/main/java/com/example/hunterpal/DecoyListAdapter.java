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

public class DecoyListAdapter extends RecyclerView.Adapter<DecoyListAdapter.ViewHolder> {

    private String[] decoyName;
    private int[] decoyImage;

    private DecoyListAdapter.Listener listener;

    public DecoyListAdapter(int[] decoyImage, String[] decoyName){
        this.decoyName = decoyName;
        this.decoyImage = decoyImage;
    }

    @NonNull
    @Override
    public DecoyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.decoy_card_view,parent,false);
        return new DecoyListAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull DecoyListAdapter.ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.decoy_card_picture);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(),decoyImage[position]);

        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(decoyName[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.decoy_card_name);
        textView.setText(decoyName[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(position);
                }
                Intent intent = new Intent(cardView.getContext(), DecoyDetail.class);
                intent.putExtra(DecoyDetail.EXTRA_DECOY_ID,position);
                cardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount(){
        return decoyName.length;
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
