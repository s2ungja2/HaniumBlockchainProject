package com.example.nam.donationmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MenuSelect extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_select);

        TextView token_change = findViewById(R.id.token_change);
        TextView donation_group = findViewById(R.id.donation_group);
        TextView donation = findViewById(R.id.donation_solo);
        TextView check_history = findViewById(R.id.check_history);
        TextView profile = findViewById(R.id.profile);
        TextView ranking = findViewById(R.id.ranking_list);

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_select = new Intent(getApplicationContext(), Donation.class);
                startActivity(intent_select);
            }
        });

        donation_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_select = new Intent(getApplicationContext(), DonationGroup.class);
                startActivity(intent_select);
            }
        });

        check_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_history = new Intent(getApplicationContext(), CheckHistory.class);
                startActivity(intent_history);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_ranking = new Intent(getApplicationContext(), RankingList.class);
                startActivity(intent_ranking);
            }
        });

        token_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_change = new Intent(getApplicationContext(), TokenChange.class);
                startActivity(intent_change);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_profile = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent_profile);
            }
        });
    }
}
