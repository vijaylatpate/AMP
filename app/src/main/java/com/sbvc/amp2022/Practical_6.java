package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_6 extends AppCompatActivity {

    Button btnPractical_6_1, btnPractical_6_2, btnPractical_6_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6);

        btnPractical_6_1 = findViewById(R.id.btnPractical_6_1);
        btnPractical_6_2 = findViewById(R.id.btnPractical_6_2);
        btnPractical_6_3 = findViewById(R.id.btnPractical_6_3);

        btnPractical_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_6_1.class));
            }
        });

        btnPractical_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_6_2.class));
            }
        });

        btnPractical_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_6_3.class));
            }
        });
    }
}