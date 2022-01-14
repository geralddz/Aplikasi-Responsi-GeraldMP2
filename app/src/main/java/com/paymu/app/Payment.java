package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.paymu.app.Fragment.FragmentHome;
import com.paymu.app.Fragment.FragmentPayment;

public class Payment extends AppCompatActivity {
    TextView titel;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        titel = findViewById(R.id.title);
        back = findViewById(R.id.back_icon);
        titel.setText("Payment");

        back.setOnClickListener(v -> {
            Intent intent = new Intent(this,Home.class);
            intent.putExtra("fragmentNumber",2);
            startActivity(intent);
        });
    }
}