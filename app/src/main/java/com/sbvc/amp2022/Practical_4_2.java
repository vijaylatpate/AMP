package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class Practical_4_2 extends AppCompatActivity {

    EditText txtUSD, txtINR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical42);

        txtUSD = findViewById(R.id.txtUSD);
        txtINR = findViewById(R.id.txtINR);

        txtUSD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!TextUtils.isEmpty(txtUSD.getText())) {
                    double val = Math.round(Double.parseDouble(txtUSD.getText().toString()) * 75.32);
                    txtINR.setText(val + "");
                }
            }
        });

        txtINR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!TextUtils.isEmpty(txtINR.getText())) {
                    double val = Math.round(Double.parseDouble(txtINR.getText().toString()) / 75.32);
                    txtUSD.setText(val + "");
                }
            }
        });
    }
}