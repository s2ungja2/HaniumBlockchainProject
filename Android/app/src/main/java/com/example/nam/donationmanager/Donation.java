package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Donation extends AppCompatActivity {
    int userNum, govNum;
    double govUpdateToken, userUpdateToken, govCurrToken, userCurrToken, donationToken;
    String govName;
    EditText token;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation);

        token = findViewById(R.id.input_token);
        btn = findViewById(R.id.submit_donation);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://14.63.194.247/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<UserRepo> getCall = api.getUserRepo();
        getCall.enqueue(new Callback<UserRepo>() {
            @Override
            public void onResponse(Call<UserRepo> call, Response<UserRepo> response) {
                UserRepo repo = response.body();
                List<UserRepo.Result> datalist = repo.result;
                userNum = datalist.get(1).user_num;
                govNum = datalist.get(3).user_num;
                govName = datalist.get(3).user_name;
                userCurrToken = datalist.get(1).user_token;
                govCurrToken = datalist.get(3).user_token;
                Log.d("get onresponse", "get onresponse");
            }

            @Override
            public void onFailure(Call<UserRepo> call, Throwable t) {
                Log.d("get onfailure", "get onfailure");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donationToken = Double.parseDouble(token.getText().toString());
                userUpdateToken = userCurrToken - donationToken;
                govUpdateToken = govCurrToken + donationToken;
                Log.d("onclick", "onclick");

                Call<UserRepo> setCall = api.setUserRepoDonation(userNum, govNum, userUpdateToken, govUpdateToken);
                setCall.enqueue(new Callback<UserRepo>() {
                    @Override
                    public void onResponse(Call<UserRepo> call, Response<UserRepo> response) {
                        Log.d("set onresponse", "set onresponse");
                    }

                    @Override
                    public void onFailure(Call<UserRepo> call, Throwable t) {
                        Log.d("set onfailure", "set onfailure");
                    }
                });
                Toast.makeText(Donation.this, govName + " 기관에 " + donationToken + " Token이 기부되었습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
