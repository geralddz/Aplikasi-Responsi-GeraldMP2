package com.paymu.app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.paymu.app.Fragment.FragmentHistory;
import com.paymu.app.Fragment.FragmentHome;
import com.paymu.app.Fragment.FragmentPayment;
import com.paymu.app.Fragment.FragmentSetting;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomnav);

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
}