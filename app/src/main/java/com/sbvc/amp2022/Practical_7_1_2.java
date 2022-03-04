package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Practical_7_1_2 extends AppCompatActivity {

    Intent intent;
    int id;
    Employee employee;
    MyDBHelper db;

    EditText txtEmployee;
    FloatingActionButton btnEdit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical712);

        txtEmployee = findViewById(R.id.txtEmployeeName);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        intent = getIntent();
        id = intent.getIntExtra("id", 0);
        if (id != 0) {
            db = new MyDBHelper(getApplicationContext());
            employee = db.getEmployee(id);
            txtEmployee.setText(employee.sname);

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    employee.setSName(txtEmployee.getText().toString());
                    if (db.EditEmployee(employee)) {
                        Toast.makeText(Practical_7_1_2.this, "Edited Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Practical_7_1_2.this, "Editing Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(db.DeleteEmployee(employee.id)){
                        Toast.makeText(Practical_7_1_2.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Practical_7_1_2.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}