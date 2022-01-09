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
import android.widget.Toolbar;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.UserDatabase;
import com.paymu.app.Data.Model.UserEntity;

import java.util.regex.Pattern;

public class Registrasi extends AppCompatActivity {
    ImageView back;
    TextView titel;
    EditText eteml, etpas, etcpas;
    Button btrgst;
    UserDAO userDAO;
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

        userDAO = Room.databaseBuilder(this, UserDatabase.class, "user.db").allowMainThreadQueries()
                .build().userDAO();

        titel.setText("Registrasi");
        back.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class );
            startActivity(i);
        });
        btrgst.setOnClickListener(v -> {
            String email = eteml.getText().toString().trim();
            String passw = etpas.getText().toString().trim();
            String konfirmasi = etcpas.getText().toString().trim();



            if (passw.length() == 0 && (konfirmasi.length() == 0)) {
                etpas.setError("Password Tidak Boleh Kosong");
            }
            else if (!passw.equals(konfirmasi)) {
                etcpas.setError("Konfirmasi Password Anda Salah");
            }
            else if (passw.equals(konfirmasi) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                UserEntity userEntity = new UserEntity(email, passw);
                userDAO.Register(userEntity);
                Toast.makeText(Registrasi.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Home.class );
                startActivity(i);;
            }
            else {
                Toast.makeText(this, "Masukkan Email dengan Benar", Toast.LENGTH_SHORT).show();
            }

        });
    }
}