package com.example.lr4.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lr4.EmployeeViewModel;
import com.example.lr4.databinding.FragmentAddEmployeeBinding;
import com.example.lr4.entities.Employee;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class AddEmployeeFragment extends Fragment {

    FragmentAddEmployeeBinding binding;

    public EmployeeViewModel employeeViewModel;

    public AddEmployeeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddEmployeeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        employeeViewModel = new ViewModelProvider(getActivity()).get(EmployeeViewModel.class);

        commitBtnInit();
        addPhotoBtn();
    }

    private void addPhotoBtn(){
        binding.photo.setOnClickListener((v) -> {
            ImagePicker.with(this).start();
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        binding.photo.setImageURI(data.getData());

    }


    private void commitBtnInit(){
        binding.commitBtn.setOnClickListener((v)->{
            String name = binding.name.getText().toString();
            String position = binding.position.getText().toString();
            Drawable photo = binding.photo.getDrawable();
            Employee employee = new Employee(name, position, photo);

            employeeViewModel.addEmployees(employee);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}