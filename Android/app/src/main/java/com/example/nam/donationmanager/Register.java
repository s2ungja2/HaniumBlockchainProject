package com.example.nam.donationmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText register_id, register_password, register_name;
    private Button btn_register;
    private ProgressBar register_loading;
    private static String URL_REGIST ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        register_loading = findViewById(R.id.register_loading);
        register_id = findViewById(R.id.register_ID);
        register_name = findViewById(R.id.register_Name);
        register_password = findViewById(R.id.register_Password);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MenuSelect.class);
                startActivity(intent);
            }
        });
    }

    private  void Regist(){
        register_loading.setVisibility(View.VISIBLE);
        btn_register.setVisibility(View.GONE);

        final String id = this.register_id.getText().toString().trim(); //delete front/back space
        final String name = this.register_name.getText().toString().trim();
        final String password = this.register_password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")) {
                                Toast.makeText(Register.this, "Register Success!", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Register.this, "Register Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                            register_loading.setVisibility(View.GONE);
                            btn_register.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

    }
}