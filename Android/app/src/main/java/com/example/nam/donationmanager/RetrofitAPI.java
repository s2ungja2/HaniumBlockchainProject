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
    Call<UserRepo> setUserRepoTokenChange(@Query("userNum") int num, @Query("userMoney") int money, @Query("userToken") double token);

    // Donation에서 기부
    @GET("donation.php")
    Call<UserRepo> setUserRepoDonation(@Query("userNum") int userNum, @Query("userNum") int govNum, @Query("userToken") double userToken, @Query("userToken") double govToken);
}
