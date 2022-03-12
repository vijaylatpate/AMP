package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class Practical_10_1 extends AppCompatActivity {

    EditText txtFirstName, txtLastName, txtUserName, txtPassword, txtConfPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical101);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfPassword = findViewById(R.id.txtConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtFirstName.getText())) {
                    Toast.makeText(getApplicationContext(), "First Name Required", Toast.LENGTH_SHORT);
                } else if (TextUtils.isEmpty(txtLastName.getText())) {
                    Toast.makeText(getApplicationContext(), "Last Name Required", Toast.LENGTH_SHORT);
                } else if (TextUtils.isEmpty(txtUserName.getText())) {
                    Toast.makeText(getApplicationContext(), "Email ID Required", Toast.LENGTH_SHORT);
                } else if (TextUtils.isEmpty(txtPassword.getText())) {
                    Toast.makeText(getApplicationContext(), "Password Required", Toast.LENGTH_SHORT);
                } else if (TextUtils.isEmpty(txtConfPassword.getText())) {
                    Toast.makeText(getApplicationContext(), "Confirm Password Required", Toast.LENGTH_SHORT);
                } else {
                    if (txtConfPassword.getText().toString().equals(txtPassword.getText().toString())) {
                        //registerUser(txtFirstName.getText().toString().trim(), txtLastName.getText().toString().trim(), txtUserName.getText().toString().trim(), txtConfPassword.getText().toString().trim());
                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords are not same", Toast.LENGTH_SHORT);
                    }
                }
            }
        });

    }

    private void registerUser(String firstname, String lastname, String username, String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success")) {
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Practical_10_1.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("firstname", firstname);
                params.put("lastname", lastname);
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}