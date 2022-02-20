package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practical_3_6 extends AppCompatActivity {

    EditText txtData;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical36);

        txtData = findViewById(R.id.txtNo);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtData.getText())) {
                    Toast.makeText(Practical_3_6.this, "Enter Data", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Practical_3_6_1.class);
                    intent.putExtra("txtData", txtData.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}