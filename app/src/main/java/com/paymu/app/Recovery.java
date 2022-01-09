package com.paymu.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.UserDatabase;
import com.paymu.app.Data.Model.UserEntity;

public class Recovery extends AppCompatActivity {
    EditText etmail;
    Button btsend;
    ImageView back;
    TextView titel;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        etmail = findViewById(R.id.etEmailrec);
        btsend = findViewById(R.id.btsent);
        back = findViewById(R.id.back_icon);
        titel = findViewById(R.id.title);

        userDAO = Room.databaseBuilder(this, UserDatabase.class, "user.db").allowMainThreadQueries()
                .build().userDAO();

        back.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        });

        btsend.setOnClickListener(v -> {
            String mail = etmail.getText().toString().trim();
            UserEntity userEntity = userDAO.recovery(mail);
            if (userEntity != null && Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                Intent i = new Intent(this, Login.class);
                startActivity(i);
                finish();
            }else{
                Toast.makeText(this, "Email Tidak Terdaftar", Toast.LENGTH_SHORT).show();
            }
        });

        titel.setText("Recovery");
    }
}