package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Recovery extends AppCompatActivity {
    EditText etmail;
    Button btsend;
    ImageView back;
    TextView titel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        etmail = findViewById(R.id.etEmailrec);
        btsend = findViewById(R.id.btsent);
        back = findViewById(R.id.back_icon);
        titel = findViewById(R.id.title);


        back.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class );
            startActivity(i);
        });

        titel.setText("Recovery");
    }
}