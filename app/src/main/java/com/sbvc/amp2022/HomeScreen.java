package com.sbvc.amp2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {
    AlertDialog.Builder builder;

    Button btnPractical1, btnPractical2, btnPractical3, btnPractical4, btnPractical5, btnPractical6, btnPractical7, btnPractical8, btnPractical9, btnPractical10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //Dialog Box Initialization
        builder = new AlertDialog.Builder(this);

        btnPractical1 = findViewById(R.id.btnPractical_1);
        btnPractical2 = findViewById(R.id.btnPractical_2);
        btnPractical3 = findViewById(R.id.btnPractical_3);
        btnPractical4 = findViewById(R.id.btnPractical_4);
        btnPractical5 = findViewById(R.id.btnPractical_5);
        btnPractical8 = findViewById(R.id.btnPractical_8);

        btnPractical6 = findViewById(R.id.btnPractical_6);
        btnPractical7 = findViewById(R.id.btnPractical_7);
        btnPractical9 = findViewById(R.id.btnPractical_9);
        btnPractical10 = findViewById(R.id.btnPractical_10);

        btnPractical1.setOnClickListener(this);
        btnPractical2.setOnClickListener(this);
        btnPractical3.setOnClickListener(this);
        btnPractical4.setOnClickListener(this);
        btnPractical5.setOnClickListener(this);
        btnPractical6.setOnClickListener(this);
        btnPractical7.setOnClickListener(this);
        btnPractical8.setOnClickListener(this);
        btnPractical9.setOnClickListener(this);
        btnPractical10.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        //Set Your  message manually and performing action on button click
        builder.setMessage("Do you want to close this application ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle(R.string.app_name);
        alert.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPractical_1:
                Toast.makeText(this, "Learn Android Architecture & Components", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPractical_2:
                Toast.makeText(this, "App Developed On Android Studio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPractical_3:
                startActivity(new Intent(getApplicationContext(), Practical_3.class));
                break;
            case R.id.btnPractical_4:
                startActivity(new Intent(getApplicationContext(), Practical_4.class));
                break;
            case R.id.btnPractical_5:
                startActivity(new Intent(getApplicationContext(), Practical_5.class));
                break;
            case R.id.btnPractical_6:
                startActivity(new Intent(getApplicationContext(), Practical_6.class));
                break;
            case R.id.btnPractical_7:
                startActivity(new Intent(getApplicationContext(), Practical_7.class));
                break;
            case R.id.btnPractical_8:
                startActivity(new Intent(getApplicationContext(), Practical_8.class));
                break;
            case R.id.btnPractical_9:
                startActivity(new Intent(getApplicationContext(), Practical_9.class));
                break;
            case R.id.btnPractical_10:
                startActivity(new Intent(getApplicationContext(), Practical_10.class));
                break;
        }
    }
}