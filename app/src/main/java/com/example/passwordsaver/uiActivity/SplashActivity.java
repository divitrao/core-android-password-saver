package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.auth0.android.jwt.JWT;
import com.example.passwordsaver.MainActivity;
import com.example.passwordsaver.R;
import com.example.passwordsaver.base.BaseActivity;
import com.example.passwordsaver.data.DataManager;

public class SplashActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        int array[] = new int[4];
        setContentView(R.layout.activity_splash);

        String access_token = DataManager.getInstance().getAccessToken();
        JWT jwt = new JWT(access_token);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(jwt.isExpired(1)){
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                else{
                    startActivity(new Intent(SplashActivity.this, PasswordList.class));
                }

                finish();      }
        },4000);
    }
}