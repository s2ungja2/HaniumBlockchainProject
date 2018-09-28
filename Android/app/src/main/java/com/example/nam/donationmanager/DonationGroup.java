package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.nam.donationmanager.ShimmerRecyclerView.BaseUtils;
import com.example.nam.donationmanager.ShimmerRecyclerView.CardAdapter;
import com.example.nam.donationmanager.ShimmerRecyclerView.DemoConfiguration;

public class DonationGroup extends AppCompatActivity {
    private ShimmerRecyclerView shimmerRecycler;
    private CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView.LayoutManager layoutManager;

        final DemoConfiguration demoConfiguration = BaseUtils.getDemoConfiguration(this);
        setContentView(demoConfiguration.getLayoutResource());
        layoutManager = demoConfiguration.getLayoutManager();

        shimmerRecycler = findViewById(R.id.shimmer_recycler_view);

        if (demoConfiguration.getItemDecoration() != null) {
            shimmerRecycler.addItemDecoration(demoConfiguration.getItemDecoration());
        }

        mAdapter = new CardAdapter();

        shimmerRecycler.setLayoutManager(layoutManager);
        shimmerRecycler.setAdapter(mAdapter);
        shimmerRecycler.showShimmerAdapter();

        shimmerRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCards();
            }
        }, 3000);
    }

    private void loadCards() {
        mAdapter.setCards(BaseUtils.getCards(getResources()));
        shimmerRecycler.hideShimmerAdapter();
    }
}
