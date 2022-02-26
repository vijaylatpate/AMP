package com.sbvc.amp2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Employee> {
    List<Employee> employees = new ArrayList<Employee>();
    Context context;

    public MyAdapter(Context context, List<Employee> lst) {
        super(context,
                R.layout.list_item_db,
                lst);
        this.employees = lst;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Employee employee = employees.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_db, parent, false);
        } else {
            view = convertView;
        }
        TextView txtID = view.findViewById(R.id.txtEmpID);
        TextView txtName = view.findViewById(R.id.txtEmpName);

        txtID.setText(employee.getnId()+"");
        txtName.setText(employee.sname);

        return view;
    }
}
