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

        TextView token_change = (TextView)findViewById(R.id.token_change);
        TextView group_select = (TextView)findViewById(R.id.group_select);
        TextView check_history = (TextView)findViewById(R.id.check_history);
        TextView profile = findViewById(R.id.profile);

        token_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), TokenChange.class);
                startActivity(intent1);
            }
        });

        group_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), GroupSelect.class);
                startActivity(intent2);
            }
        });

        check_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), CheckHistory.class);
                startActivity(intent3);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), Profile.class);
                startActivity(intent4);
            }
        });
    }
}
