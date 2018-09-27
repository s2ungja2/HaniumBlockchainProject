package com.example.nam.donationmanager;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {
    // Profile에 정보를 가져옴
    @GET("userinfo.php")
    Call<UserRepo> getUserRepo();

    // TokenChange에서 값 교환
    @GET("tokenchange.php")
    Call<UserRepo> setUserRepo(@Query("userNum") int num, @Query("userMoney") int money, @Query("userToken") double token);
}
