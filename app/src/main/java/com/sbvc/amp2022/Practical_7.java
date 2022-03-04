package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_7 extends AppCompatActivity {

    Button btnPractical_7_1, btnPractical_7_2, btnPractical_7_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical7);

        btnPractical_7_1 = findViewById(R.id.btnPractical_7_1);
        btnPractical_7_2 = findViewById(R.id.btnPractical_7_2);
        btnPractical_7_3 = findViewById(R.id.btnPractical_7_3);

        btnPractical_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_7_1.class));
            }
        });

        btnPractical_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_7_2.class));
            }
        });
    }
}