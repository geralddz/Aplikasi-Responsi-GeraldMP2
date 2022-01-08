package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class Registrasi extends AppCompatActivity {
    ImageView back;
    TextView titel;
    EditText eteml, etpas, etcpas;
    Button btrgst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        eteml = findViewById(R.id.etEmail1);
        etpas = findViewById(R.id.etpass1);
        etcpas = findViewById(R.id.etkonfirm);
        btrgst = findViewById(R.id.btregis);
        back = findViewById(R.id.back_icon);
        titel = findViewById(R.id.title);

        titel.setText("Registrasi");
        back.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class );
            startActivity(i);
        });
        btrgst.setOnClickListener(v -> {
            Intent i = new Intent(this, Home.class );
            startActivity(i);
        });
    }
}