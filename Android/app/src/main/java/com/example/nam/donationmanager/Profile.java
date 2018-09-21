package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Profile extends AppCompatActivity{
    TextView id, name, email, sex, rank, count, money, token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        id = findViewById(R.id.profile_id);
        name = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_email);
        sex = findViewById(R.id.profile_sex);
        rank = findViewById(R.id.profile_rank);
        count = findViewById(R.id.profile_count);
        money = findViewById(R.id.profile_money);
        token = findViewById(R.id.profile_token);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://14.63.194.247/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<UserRepo> call = api.getUserRepo();
        call.enqueue(new Callback<UserRepo>() {
            @Override
            public void onResponse(Call<UserRepo> call, Response<UserRepo> response) {
                if(response.isSuccessful()){
                    UserRepo repo = response.body();
                    id.setText(String.valueOf(repo.result.getUserId()));
                    name.setText(String.valueOf(repo.result.getUserName()));
                    email.setText(String.valueOf(repo.result.getUserEmail()));
                    sex.setText(String.valueOf(repo.result.getUserSex()));
                    rank.setText(String.valueOf(repo.result.getUserRank()));
                    count.setText(String.valueOf(repo.result.getUserCount()));
                    money.setText(String.valueOf(repo.result.getUserMoney()));
                    token.setText(String.valueOf(repo.result.getUserToken()));
                }
            }

            @Override
            public void onFailure(Call<UserRepo> call, Throwable t) {

            }
        });
    }
}
