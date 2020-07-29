package com.example.bitsandpizzarestaurant;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder> {

    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener{
        public void onClick(int i);

    }

    public CaptionedImageAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_captioned_image,viewGroup,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final CardView cardView = viewHolder.cardView;
        final ImageView imageView = cardView.findViewById(R.id.imageId);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[i]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[i]);
        TextView textView = cardView.findViewById(R.id.captionTextId);
        textView.setText(captions[i]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView;
        }
    }
}
