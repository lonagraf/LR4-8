package com.example.lr4;

import android.app.Application;

import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.AndroidViewModel;

import com.example.lr4.entities.Employee;

import java.util.ArrayList;

public class EmployeeViewModel extends AndroidViewModel {
    private final ArrayList<Employee> employees = new ArrayList<>();
    public EmployeeViewModel(Application app)
    {
        super(app);
        employees.add(new Employee("Иван", "Бухгалтер", ResourcesCompat.getDrawable(app.getResources(), R.drawable.photo1,null)));
        employees.add(new Employee("Петр", "Руководитель",ResourcesCompat.getDrawable(app.getResources(), R.drawable.photo2,null)));
        employees.add(new Employee("Константин", "Кассир",ResourcesCompat.getDrawable(app.getResources(), R.drawable.photo3,null)));
        employees.add(new Employee("Максим", "Программист",ResourcesCompat.getDrawable(app.getResources(), R.drawable.photo4,null)));
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public void addEmployees(Employee employee){
        employees.add(employee);
    }
}
