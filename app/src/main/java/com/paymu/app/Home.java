package com.paymu.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.AppUser;
import com.paymu.app.Fragment.FragmentHistory;
import com.paymu.app.Fragment.FragmentHome;
import com.paymu.app.Fragment.FragmentPayment;
import com.paymu.app.Fragment.FragmentSetting;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Session session;
    Toolbar toolbar;
    TextView tvnama;
    UserDAO userDAO;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnav);
        toolbar = findViewById(R.id.toolbar2);
        tvnama = findViewById(R.id.tvname);
        session = new Session(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if(session.loggedin()){
            String name = getIntent().getStringExtra("name");
            tvnama.setText(name);
        }
        userDAO = AppUser.db.userDAO();
        String name = getIntent().getStringExtra("name");
        tvnama.setText(name);
        session.setLoggedin(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menu:
                    fragment = new FragmentHome();
                    break;

                case R.id.payment:
                    fragment = new FragmentPayment();
                    break;
                case R.id.history:
                    fragment = new FragmentHistory();
                    break;
                case R.id.setting:
                    fragment = new FragmentSetting();
                    break;
            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout1) {
            session.setLoggedin(false);
            finish();
            startActivity(new Intent(this,Login.class));
            Toast.makeText(this, "LOG-OUT Berhasil!!!", Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}