package com.example.lr4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private LayoutInflater inflater;
    private int layout;
    private List<Employee> employees;

    public EmployeeAdapter(Context context, int resource, List<Employee> employees) {
        super(context, resource, employees);
        this.employees = employees;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView photoView = view.findViewById(R.id.photo);
        TextView nameView = view.findViewById(R.id.name);
        TextView positionView = view.findViewById(R.id.jobPosition);

        Employee employee = employees.get(position);

        photoView.setImageResource(employee.getPhotoResource());
        nameView.setText(employee.getName());
        positionView.setText(employee.getJobPosition());

        return view;
    }
}
