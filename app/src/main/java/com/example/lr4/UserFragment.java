
package com.example.lr4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class UserFragment extends Fragment {

    ArrayList<Employee> employees = new ArrayList<Employee>();
    ListView employeesList;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();
        employeesList = view.findViewById(R.id.employeesList);
        EmployeeAdapter  employeeAdapter = new EmployeeAdapter(view.getContext(), R.layout.layout, employees);
        employeesList.setAdapter(employeeAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
    private void setInitialData()
    {
        employees.add(new Employee("Иван", "Бухгалтер",R.drawable.photo1));
        employees.add(new Employee("Петр", "Руководитель",R.drawable.photo2));
        employees.add(new Employee("Константин", "Кассир",R.drawable.photo3));
        employees.add(new Employee("Максим", "Программист",R.drawable.photo4));
    }
}