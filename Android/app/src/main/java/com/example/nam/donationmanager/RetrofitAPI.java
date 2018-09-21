package com.example.nam.donationmanager;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("/userinfo.php")
    Call<UserRepo> getUserRepo();
}
