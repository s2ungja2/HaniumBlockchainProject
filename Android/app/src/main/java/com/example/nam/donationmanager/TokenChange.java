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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TokenChange extends AppCompatActivity {
    EditText won;
    TextView token;
    Button change;
    double change_token;

    int updateMoney, userNum;
    double updateToken, currToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.token_change);

        won = findViewById(R.id.won);
        token = findViewById(R.id.token);
        change = findViewById(R.id.change);

        DecimalFormat decimalFormat = new DecimalFormat("#,###");       //숫자 형식 정해줌
        won.addTextChangedListener(textWatcher);

        final Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://14.63.194.247/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitAPI api = retrofit.create(RetrofitAPI.class);
                Call<UserRepo> getCall = api.getUserRepo();
                getCall.enqueue(new Callback<UserRepo>() {
                    @Override
                    public void onResponse(Call<UserRepo> call, Response<UserRepo> response) {
                        UserRepo repo = response.body();
                        List<UserRepo.Result> datalist = repo.result;
                        userNum = datalist.get(0).user_num;
                        currToken = datalist.get(0).user_token;
                        updateMoney = datalist.get(0).user_money - Integer.parseInt(won.getText().toString());
                        updateToken = currToken + change_token;
                        Toast.makeText(TokenChange.this, ""+userNum+"/"+updateMoney+"/"+updateToken, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserRepo> call, Throwable t) {
                        Toast.makeText(TokenChange.this, "get 실패", Toast.LENGTH_SHORT).show();
                    }
                });
                Call<UserRepo> setCall = api.setUserRepo(userNum, updateMoney, updateToken);
                setCall.enqueue(new Callback<UserRepo>() {
                    @Override
                    public void onResponse(Call<UserRepo> call, Response<UserRepo> response) {
                        Toast.makeText(TokenChange.this, change_token + "토큰이 교환되었습니다.", Toast.LENGTH_LONG).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<UserRepo> call, Throwable t) {
                        //Toast.makeText(TokenChange.this, "set 실패", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
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
