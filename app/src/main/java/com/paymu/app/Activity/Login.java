package com.paymu.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.AppUser;
import com.paymu.app.Data.Model.UserEntity;
import com.paymu.app.R;
import com.paymu.app.Session;

public class Login extends AppCompatActivity {
    TextView tvreg, tvpas1;
    EditText etmail, etpas;
    Button login;
    UserDAO userDAO;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvreg = findViewById(R.id.tvrg);
        tvpas1 = findViewById(R.id.tvfgtpass);
        etmail = findViewById(R.id.etEmail);
        etpas = findViewById(R.id.etpass);
        login = findViewById(R.id.btlogin);
        session = new Session(this);

        userDAO = AppUser.db.userDAO();

        if(session.loggedin()){
            startActivity(new Intent(this,Home.class));
            finish();
        }

       login.setOnClickListener(v -> {
           String mail = etmail.getText().toString().trim();
           String passw = etpas.getText().toString().trim();
           UserEntity userEntity = userDAO.login(mail, passw);

           if (userEntity != null && Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
               session.setLoggedin(true);
               Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
               String name = userEntity.getEmail();
               Intent i = new Intent(this, Home.class)
                       .putExtra("name", name);
               startActivity(i);
               finish();
           }else{
               Toast.makeText(this, "Isikan Email dan Password Dengan Benar", Toast.LENGTH_SHORT).show();
           }
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