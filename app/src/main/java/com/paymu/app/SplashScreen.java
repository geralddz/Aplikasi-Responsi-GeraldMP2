package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int load = 3000;

        new Handler().postDelayed(() -> {
            Intent SplashScreen = new Intent (this, Login.class);
            startActivity(SplashScreen);
            finish();
        },load);
    }
}