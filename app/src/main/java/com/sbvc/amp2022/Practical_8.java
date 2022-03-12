package com.sbvc.amp2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class Practical_8 extends AppCompatActivity {

    Button btnPractical8_1;
    Button btnPractical8_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8);
        btnPractical8_1 = findViewById(R.id.btn_practical8_1);
        btnPractical8_2 = findViewById(R.id.btn_practical8_2);
        btnPractical8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNotifiaction();
            }
        });
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                    }
                });
    }

    private void getNotifiaction() {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel("myNotification", "myNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "myNotification")
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Exam Notification")
                .setContentText("We are ready for offline exams.")
                .setSound(uri);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(999, builder.build());


    }
}