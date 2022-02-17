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

    Button btnPractical1, btnPractical2, btnPractical3, btnPractical4, btnPractical5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //Dialog Box Initialization
        builder = new AlertDialog.Builder(this);

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

        }
    }
}