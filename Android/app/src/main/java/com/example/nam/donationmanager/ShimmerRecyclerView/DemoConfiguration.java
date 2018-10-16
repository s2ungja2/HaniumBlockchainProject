package com.example.nam.donationmanager.ShimmerRecyclerView;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

public class DemoConfiguration {
    @LayoutRes
    private int layoutResource;

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerView.ItemDecoration itemDecoration;

    public RecyclerView.ItemDecoration getItemDecoration() {
        return itemDecoration;
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    public int getLayoutResource() {
        return layoutResource;
    }

    public void setLayoutResource(int layoutResource) {
        this.layoutResource = layoutResource;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }
}
