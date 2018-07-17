package com.example.nam.donationmanager;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alicek on 2015-10-13.
 */
class URLConnector extends Thread {

    String userinfo;
    String govinfo;

    public void run() {

        // http 요청을 쏴서 그에 대한 결과값을 받아온다.
        final String output1 = request("http://14.63.194.247/userInfo.php");
        final String output2 = request("http://14.63.194.247/govInfo.php");

        // json형태의 결과값이 userinfo / govinfo에 각각 담긴다.
        userinfo = output1;
        govinfo = output2;
    }

    public String getUserinfo(){
        return userinfo;
    }

    public String getGovinfo(){
        return govinfo;
    }

    private String request(String urlStr) {
        StringBuilder output = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                int resCode = conn.getResponseCode();
                if (resCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())) ;
                    String line = null;
                    while(true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        output.append(line + "\n");
                    }

                    reader.close();
                    conn.disconnect();
                }
            }
        } catch(Exception ex) {
            Log.e("SampleHTTP", "Exception in processing response.", ex);
            ex.printStackTrace();
        }

        return output.toString();
    }
}