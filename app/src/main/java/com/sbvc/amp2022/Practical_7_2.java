package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practical_7_2 extends AppCompatActivity {

    EditText txtRollNo;
    Button btnAddPreference;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical72);

        txtRollNo = findViewById(R.id.txtRollNo);

        btnAddPreference = findViewById(R.id.btnAdd);

        sharedPreferences = getSharedPreferences("Roll_No", Context.MODE_PRIVATE);

        btnAddPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPreferences.contains("Roll")) {
                    Toast.makeText(Practical_7_2.this, "Already Exists", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Roll", txtRollNo.getText().toString());
                    editor.apply();
                    Toast.makeText(Practical_7_2.this, "Preference Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}