package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.paymu.app.Fragment.FragmentPayment;
import com.paymu.app.Fragment.FragmentSetting;

public class Profile extends AppCompatActivity {
    TextView titel;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        back = findViewById(R.id.back_icon);
        titel = findViewById(R.id.title);
        titel.setText("Profile");

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this,Home.class);
            intent.putExtra("fragmentNumber",1);
            startActivity(intent);
        });

    }
}