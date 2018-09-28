package com.example.nam.donationmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Profile extends AppCompatActivity{
    TextView id, name, email, sex, count, money, token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        id = findViewById(R.id.profile_id);
        name = findViewById(R.id.profile_name);
        email = findViewById(R.id.profile_email);
        sex = findViewById(R.id.profile_sex);
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
                    List<UserRepo.Result> datalist = repo.result;

                    id.setText(datalist.get(1).user_id.toString());
                    name.setText(datalist.get(1).user_name.toString());
                    email.setText(datalist.get(1).user_email.toString());
                    if(datalist.get(1).user_sex == false)
                        sex.setText("남자");
                    else
                        sex.setText("여자");
                    count.setText(""+datalist.get(1).user_count);
                    money.setText(""+datalist.get(1).user_money);
                    token.setText(""+datalist.get(1).user_token);
                }
            }

            @Override
            public void onFailure(Call<UserRepo> call, Throwable t) {
                Toast.makeText(Profile.this, "실패", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
