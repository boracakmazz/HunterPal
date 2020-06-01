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

public class CallerListAdapter extends RecyclerView.Adapter<CallerListAdapter.ViewHolder> {
    private String[] callerName;
    private int[] callerImage;

    private CallerListAdapter.Listener listener;

    public CallerListAdapter(int[] callerImage, String[] callerName){
        this.callerName = callerName;
        this.callerImage = callerImage;
    }

    @NonNull
    @Override
    public CallerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.caller_card_view,parent,false);
        return new CallerListAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull CallerListAdapter.ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.caller_card_picture);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(),callerImage[position]);

        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(callerName[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.caller_card_name);
        textView.setText(callerName[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(position);
                }
                Intent intent = new Intent(cardView.getContext(), CallerDetail.class);
                intent.putExtra(CallerDetail.EXTRA_CALLER_ID,position);
                cardView.getContext().startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount(){
        return callerName.length;
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


