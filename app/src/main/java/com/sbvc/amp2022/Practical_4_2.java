package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Practical_4_2 extends AppCompatActivity {

    EditText txtUSD, txtINR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical42);

        txtUSD = findViewById(R.id.txtUSD);
        txtINR = findViewById(R.id.txtINR);

        txtUSD.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double val = Math.round(Double.parseDouble(txtUSD.getText().toString()) * 75.32);
                txtINR.setText(val + "");
            }
        });

        txtINR.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                double val = Math.round(Double.parseDouble(txtINR.getText().toString()) / 75.32);
                txtINR.setText(val + "");
            }
        });
    }
}