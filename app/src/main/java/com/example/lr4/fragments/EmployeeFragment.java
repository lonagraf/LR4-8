
package com.example.lr4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lr4.EmployeeViewModel;
import com.example.lr4.R;
import com.example.lr4.adapters.EmployeeAdapter;
import com.example.lr4.databinding.FragmentEmployeeBinding;


public class EmployeeFragment extends Fragment {

    FragmentEmployeeBinding binding;
    public EmployeeViewModel employeeViewModel;
    ListView employeesList;
    public EmployeeFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmployeeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        employeeViewModel = new ViewModelProvider(getActivity()).get(EmployeeViewModel.class);
        setInitList(view);
        addEmployeeBtnInit();
    }
    private void setInitList(View view) {
        employeesList = binding.employeesList;
        EmployeeAdapter employeeAdapter = new EmployeeAdapter(this.getContext(), R.layout.layout, employeeViewModel.getEmployees());
        employeesList.setAdapter(employeeAdapter);
        employeesList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item = String.valueOf(employeeViewModel.getEmployees().get(position));
                employeeViewModel.getEmployees().remove(position);
                employeeAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addEmployeeBtnInit(){
       binding.addEmployeeBtn.setOnClickListener((view)->{getActivity().getSupportFragmentManager().beginTransaction()
               .replace(R.id.main_fragment, new AddEmployeeFragment(), "add_employee")
               .addToBackStack(null)
               .commit();});
    }
}