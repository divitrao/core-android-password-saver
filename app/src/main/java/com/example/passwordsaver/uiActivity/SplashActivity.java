package com.example.passwordsaver.uiActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.passwordsaver.MainActivity;
import com.example.passwordsaver.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        int array[] = new int[4];
        setContentView(R.layout.activity_splash);

        Intent home = new Intent(SplashActivity.this, LoginActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(home);
                finish();      }
        },4000);
    }
}