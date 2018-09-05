package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonationSolo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_solo);

//        Button submit = findViewById(R.id.submit_donation);
//        EditText solo_token = findViewById(R.id.solo_token); // EditText가 Double에 담겨서 Toast로 보여주는거 해야됨
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(DonationSolo.this, "토큰이 기부되었습니다.", Toast.LENGTH_LONG).show();
//                finish();
//            }
//        });
    }
}
