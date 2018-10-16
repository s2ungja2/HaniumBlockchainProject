package com.example.nam.donationmanager.ShimmerRecyclerView;

import android.graphics.drawable.Drawable;

public class ItemCard {

    private String mTitle;
    private String mDescription;
    private Drawable mThumbnailUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Drawable getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(Drawable mThumbnailUrl) {
        this.mThumbnailUrl = mThumbnailUrl;
    }

}

