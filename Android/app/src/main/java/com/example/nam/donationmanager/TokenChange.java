package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TokenChange extends AppCompatActivity {
    EditText won;
    TextView token;
    Button change;
    Double change_token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.token_change);

        won = findViewById(R.id.won);
        token = findViewById(R.id.token);
        change = findViewById(R.id.change);

        DecimalFormat decimalFormat = new DecimalFormat("#,###");       //숫자 형식 정해줌
        won.addTextChangedListener(textWatcher);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TokenChange.this, change_token + "토큰이 교환되었습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    TextWatcher textWatcher = new TextWatcher() {       //EditText 변화 있는지 확인해줌
        String won_result;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(!TextUtils.isEmpty(charSequence.toString()) && !charSequence.toString().equals(won_result)){
                int temp = Integer.parseInt(won.getText().toString());
//                    won_result = decimalFormat.format(Double.parseDouble(charSequence.toString().replaceAll(",","")));
//                    won.setText(won_result);
//                    won.setSelection(won_result.length());
                double tokenvalue = temp/100.0;
                change_token = tokenvalue;
//                    token_result = decimalFormat.format(Double.parseDouble(String.valueOf(tokenvalue).replaceAll(",", "")));
//                    token.setText(token_result);
                token.setText(String.valueOf(tokenvalue));
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
