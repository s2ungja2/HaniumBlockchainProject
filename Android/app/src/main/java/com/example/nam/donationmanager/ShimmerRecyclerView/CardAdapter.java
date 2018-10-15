package com.example.nam.donationmanager.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<ItemHolder> {

    private List<ItemCard> mCards = new ArrayList<>();

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(mCards.get(position));
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    public void setCards(List<ItemCard> cards) {
        if (cards == null) {
            return;
        }

        mCards = cards;
    }
}

