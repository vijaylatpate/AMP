package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Practical_3_4 extends AppCompatActivity {

    EditText txtFirstName, txtLastName;
    FloatingActionButton fabAdd;
    ListView lstStudents;
    public static List<Student> studentList = new ArrayList<Student>();
    List<String> students = new ArrayList<String>();
    int counter;
    final ArrayAdapter<String> arrayAdapter = null;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical34);

        lstStudents = findViewById(R.id.lstStudents);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        fabAdd = findViewById(R.id.btnAddToList);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, students);
        lstStudents.setAdapter(arrayAdapter);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtFirstName.getText())) {
                    Toast.makeText(Practical_3_4.this, "Enter First Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(txtLastName.getText())) {
                    Toast.makeText(Practical_3_4.this, "Enter Last Name", Toast.LENGTH_SHORT).show();
                } else {
                    counter = studentList.size();
                    Student s = new Student();
                    s.setnID(studentList.size() + 1);
                    s.setsFirstName(txtFirstName.getText().toString());
                    s.setsLastName(txtLastName.getText().toString());
                    studentList.add(s);
                    students.add(txtFirstName.getText().toString() + " " + txtLastName.getText().toString());
                    // next thing you have to do is check if your adapter has changed
                    arrayAdapter.notifyDataSetChanged();
                    txtLastName.setText("");
                    txtFirstName.setText("");
                    txtFirstName.requestFocus();

                }
            }
        });
    }
}