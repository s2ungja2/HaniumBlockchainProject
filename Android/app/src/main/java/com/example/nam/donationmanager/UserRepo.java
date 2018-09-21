package com.example.nam.donationmanager;

import com.google.gson.annotations.SerializedName;

public class UserRepo {
    @SerializedName("result") Result result;

    public class Result{
        @SerializedName("userNum") int user_num;
        @SerializedName("userId") String user_id;
//      @SerializedName("userPw") String user_pw;
        @SerializedName("userName") String user_name;
        @SerializedName("userEmail") String user_email;
        @SerializedName("userSex") boolean user_sex;
        @SerializedName("userRank") int user_rank;
        @SerializedName("userDonationcount") int user_count;
        @SerializedName("userMoney") int user_money;
        @SerializedName("userToken") double user_token;
//      @SerializedName("userGov")

//      public int getUserNum() {return user_num;}
        public String getUserId() {return user_id;}
//      public String getUserPw() {return user_pw;}
        public String getUserName() {return user_name;}
        public String getUserEmail() {return user_email;}
        public boolean getUserSex() {return user_sex;}
        public int getUserRank() {return user_rank;}
        public int getUserCount() {return user_count;}
        public int getUserMoney() {return user_money;}
        public double getUserToken() {return  user_token;}
    }
}
