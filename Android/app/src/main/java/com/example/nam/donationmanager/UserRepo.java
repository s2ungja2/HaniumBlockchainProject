package com.example.nam.donationmanager;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserRepo {
    @SerializedName("result")
    List<Result> result;

    public class Result{
        @SerializedName("userNum") int user_num;
        @SerializedName("userId") String user_id;
        @SerializedName("userPw") String user_pw;
        @SerializedName("userName") String user_name;
        @SerializedName("userEmail") String user_email;
        @SerializedName("userSex") boolean user_sex;
        //@SerializedName("userRank") int user_rank;
        @SerializedName("userDonationcount") int user_count;
        @SerializedName("userMoney") int user_money;
        @SerializedName("userToken") double user_token;
    }
}
