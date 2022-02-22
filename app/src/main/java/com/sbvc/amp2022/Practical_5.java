package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_5 extends AppCompatActivity {

    Button btnPractical5_1, btnPractical5_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5);

        btnPractical5_1 = findViewById(R.id.btnPractical_5_1);
        btnPractical5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_5_1.class));
            }
        });

        btnPractical5_2 = findViewById(R.id.btnPractical_5_2);
        btnPractical5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_5_2.class));
            }
        });
    }
}