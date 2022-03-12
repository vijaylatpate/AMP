package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Practical_9 extends AppCompatActivity {
    Button practical9_1, practical9_2, practical9_3, practical9_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9);
        practical9_1 = findViewById(R.id.practical9_1);
        practical9_2 = findViewById(R.id.practical9_2);
        practical9_3 = findViewById(R.id.practical9_3);
        practical9_4 = findViewById(R.id.practical9_4);
        practical9_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = String.format(Locale.ENGLISH, "https://maps.google.com/maps?q=loc:%f,%f", 19.2288, 72.9182);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        practical9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"));//Add Your No. To It
                if (ActivityCompat.checkSelfPermission(Practical_9.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);

                } else {
                    Toast.makeText(Practical_9.this, "No permission granted", Toast.LENGTH_SHORT).show();
                }

            }
        });
        practical9_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("", null, "hope,exam will be offline", null, null);
                Toast.makeText(Practical_9.this, "sms send ", Toast.LENGTH_SHORT).show();
            }
        });
        practical9_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_9_1.class));
            }
        });

    }
}