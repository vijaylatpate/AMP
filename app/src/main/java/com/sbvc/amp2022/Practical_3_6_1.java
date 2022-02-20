package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Practical_3_6_1 extends AppCompatActivity {

    Intent intent;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical361);

        intent = getIntent();
        txt = intent.getStringExtra("txtData");
        Toast.makeText(this, "Entered Data " + txt.toString(), Toast.LENGTH_SHORT).show();
    }
}