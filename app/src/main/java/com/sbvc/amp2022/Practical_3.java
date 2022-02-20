package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_3 extends AppCompatActivity implements View.OnClickListener {

    Button btnPractical3_1, btnPractical3_2, btnPractical3_3, btnPractical3_4, btnPractical3_5, btnPractical3_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical3);

        btnPractical3_1 = findViewById(R.id.btnPractical_3_1);
        btnPractical3_2 = findViewById(R.id.btnPractical_3_2);
        btnPractical3_3 = findViewById(R.id.btnPractical_3_3);
        btnPractical3_4 = findViewById(R.id.btnPractical_3_4);
        btnPractical3_5 = findViewById(R.id.btnPractical_3_5);
        btnPractical3_6 = findViewById(R.id.btnPractical_3_6);

        btnPractical3_1.setOnClickListener(this);
        btnPractical3_2.setOnClickListener(this);
        btnPractical3_3.setOnClickListener(this);
        btnPractical3_4.setOnClickListener(this);
        btnPractical3_5.setOnClickListener(this);
        btnPractical3_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPractical_3_1:
                startActivity(new Intent(getApplicationContext(), Practical_3_1.class));
                break;
            case R.id.btnPractical_3_2:
                startActivity(new Intent(getApplicationContext(), Practical_3_2.class));
                break;
            case R.id.btnPractical_3_3:
                startActivity(new Intent(getApplicationContext(), Practical_3_3.class));
                break;
            case R.id.btnPractical_3_4:
                startActivity(new Intent(getApplicationContext(), Practical_3_4.class));
                break;
            case R.id.btnPractical_3_5:
                startActivity(new Intent(getApplicationContext(), Practical_3_5.class));
                break;
            case R.id.btnPractical_3_6:
                startActivity(new Intent(getApplicationContext(), Practical_3_6.class));
                break;
        }
    }
}