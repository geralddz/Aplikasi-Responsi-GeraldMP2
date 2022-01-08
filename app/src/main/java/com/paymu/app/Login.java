package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView tvreg, tvpas1;
    EditText etmail, etpas;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvreg = findViewById(R.id.tvrg);
        tvpas1 = findViewById(R.id.tvfgtpass);
        etmail = findViewById(R.id.etEmail);
        etpas = findViewById(R.id.etpass);
        login = findViewById(R.id.btlogin);

       login.setOnClickListener(v -> {
           Intent i = new Intent(this, Home.class );
           startActivity(i);
       });

       tvpas1.setOnClickListener(v -> {
           Intent i = new Intent(this, Recovery.class );
           startActivity(i);
       });

       tvreg.setOnClickListener(v -> {
           Intent i = new Intent(this, Registrasi.class );
           startActivity(i);
       });

    }
}