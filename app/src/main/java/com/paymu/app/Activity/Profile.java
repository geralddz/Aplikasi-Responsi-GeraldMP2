package com.paymu.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.paymu.app.R;

public class Profile extends AppCompatActivity {
    TextView titel;
    ImageView back;
    SharedPreferences preferences;
    EditText nama, email, address;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        back = findViewById(R.id.back_icon);
        save = findViewById(R.id.btsave);
        titel = findViewById(R.id.title);
        nama = findViewById(R.id.etname);
        email = findViewById(R.id.etmail);
        address = findViewById(R.id.etaddress);

        titel.setText("Profile");
        preferences = getSharedPreferences("User", 0);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this,Home.class);
            intent.putExtra("fragmentNumber",1);
            startActivity(intent);
        });

        save.setOnClickListener(v -> {
            String inputnama = nama.getText().toString();
            String inputemail= email.getText().toString();
            String inputaddress = address.getText().toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email", inputemail);
            editor.putString("nama", inputnama);
            editor.putString("alamat", inputaddress);
            editor.apply();
            Toast.makeText(this, "Profile Tersimpan", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        });

    }
}