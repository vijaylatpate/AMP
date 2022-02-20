package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practical_4_1 extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnLogin;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical41);

        btnLogin = findViewById(R.id.btnLogin);
        txtPassword = findViewById(R.id.txtUserPassword);
        txtUsername = findViewById(R.id.txtUserName);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtUsername.getText()) && TextUtils.isEmpty(txtPassword.getText())) {
                    Toast.makeText(Practical_4_1.this, "Enter Credentials", Toast.LENGTH_SHORT).show();
                } else {
                    if (txtUsername.getText().toString().equals("SBVC") && txtPassword.getText().toString().equals("SBVC@123")) {
                        Toast.makeText(Practical_4_1.this, "Login Success", Toast.LENGTH_SHORT).show();
                    } else {
                        counter++;
                        Toast.makeText(Practical_4_1.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        if (counter == 3) {
                            txtPassword.setEnabled(false);
                            txtUsername.setEnabled(false);
                            btnLogin.setEnabled(false);
                            Toast.makeText(Practical_4_1.this, "Controls are disabled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}