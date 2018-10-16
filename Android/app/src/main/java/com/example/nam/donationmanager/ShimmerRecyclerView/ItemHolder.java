package com.example.nam.donationmanager.ShimmerRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nam.donationmanager.Donation;
import com.example.nam.donationmanager.DonationGroup;
import com.example.nam.donationmanager.Login;
import com.example.nam.donationmanager.R;

public class ItemHolder extends RecyclerView.ViewHolder {

    private TextView mTitleView;
    private TextView mDescView;
    //private ImageView mThumbnailView;
    public Button mSubmit = itemView.findViewById(R.id.card_submit);


    public static ItemHolder newInstance(ViewGroup container) {
        View root = LayoutInflater.from(container.getContext()).inflate(getLayoutResourceId(),
                container, false);
        return new ItemHolder(root);
    }

    public ItemHolder(View itemView) {
        super(itemView);
        mTitleView = itemView.findViewById(R.id.card_title);
        mDescView = itemView.findViewById(R.id.card_subtitle);
        //mThumbnailView = itemView.findViewById(R.id.card_image);
    }

    public void bind(ItemCard card){
        mTitleView.setText(card.getTitle());
        mDescView.setText(card.getDescription());
        //Glide.with(itemView.getContext()).load(card.getThumbnailUrl()).into(mThumbnailView);
    }

    private static int getLayoutResourceId() {
        int selectedLayoutResource;
        selectedLayoutResource = R.layout.group_card;
        return selectedLayoutResource;
    }
}
