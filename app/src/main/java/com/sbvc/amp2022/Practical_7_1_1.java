package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practical_7_1_1 extends AppCompatActivity {

    EditText txtName;
    Button btnAdd;
    MyDBHelper myDBHelper;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical711);

        btnAdd = findViewById(R.id.btnAdd);
        txtName = findViewById(R.id.txtEmployeeName);
        myDBHelper = new MyDBHelper(getApplicationContext());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtName.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Name of Employee", Toast.LENGTH_SHORT).show();
                } else {
                    employee = new Employee();
                    employee.setId(0);
                    employee.setSName(txtName.getText().toString().trim());
                    if (myDBHelper.AddEmployee(employee)) {
                        Toast.makeText(getApplicationContext(), "Employee Added Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error While Adding Employee", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}