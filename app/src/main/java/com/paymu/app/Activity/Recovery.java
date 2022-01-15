package com.paymu.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.paymu.app.Data.DAO.UserDAO;
import com.paymu.app.Data.Database.AppUser;
import com.paymu.app.Data.Model.UserEntity;
import com.paymu.app.R;

public class Recovery extends AppCompatActivity {
    EditText etmail;
    Button btsend;
    ImageView back;
    TextView titel;
    UserDAO userDAO;
    String channelnotif = "recovery";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        etmail = findViewById(R.id.etEmailrec);
        btsend = findViewById(R.id.btsent);
        back = findViewById(R.id.back_icon);
        titel = findViewById(R.id.title);
        userDAO = AppUser.db.userDAO();

        back.setOnClickListener(v -> {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        });

        btsend.setOnClickListener(v -> {
            String mail = etmail.getText().toString().trim();
            UserEntity userEntity = userDAO.recovery(mail);
            if (userEntity != null && Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"Testing Notif");
                builder.setContentTitle("Email telah terkirim");
                builder.setContentText("Recovery sedang di proses :)");
                builder.setSmallIcon(R.drawable.ic_baseline_account_circle_24);
                builder.setAutoCancel(true);

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel notificationChannel = new
                            NotificationChannel(channelnotif, "contoh channel", importance);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    builder.setChannelId(channelnotif);
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel);
                }
                assert mNotificationManager != null;
                mNotificationManager.notify((int) System.currentTimeMillis(), builder.build());
                Toast.makeText(this, "Recovery Berhasil", Toast.LENGTH_SHORT).show();
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