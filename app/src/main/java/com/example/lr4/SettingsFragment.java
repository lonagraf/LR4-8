package com.example.lr4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lr4.adapters.EmployeeAdapter;
import com.example.lr4.databinding.FragmentSettingsBinding;
import com.example.lr4.entities.Employee;


public class SettingsFragment extends Fragment {

    private static final String SETTINGS_ARG = "param1";
    private Employee employee;
    private EmployeeAdapter adapter;
    private FragmentSettingsBinding binding;
    SharedPreferences settings;
    private static final String PREF_NAME = "Name";

    public SettingsFragment() {}

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(SETTINGS_ARG, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            employee = (Employee) (getArguments().getSerializable(SETTINGS_ARG));
        }
        settings = getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.saveBtn.setOnClickListener(v -> SaveSettings());
        GetSettings();
    }

    public void SaveSettings(){
        String name = binding.name.getText().toString();
        String surname = binding.surname.getText().toString();
        SharedPreferences prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("NAME", name);
        editor.putString("SURNAME", surname);
        editor.putInt("FONT_SELECTION", binding.changeFont.getSelectedItemPosition());
        editor.putInt("SIZE_SELECTION", binding.changeSize.getSelectedItemPosition());
        editor.putInt("COLOR_SELECTION", binding.changeColor.getSelectedItemPosition());
        editor.apply();
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    public void GetSettings(){
        SharedPreferences pref = requireContext().getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );
        String name = pref.getString("NAME", null);
        String surname = pref.getString("SURNAME", null);
        binding.name.setText(name);
        binding.surname.setText(surname);
        int fontSelection = pref.getInt("FONT_SELECTION", 0);
        int sizeSelection = pref.getInt("SIZE_SELECTION", 0);
        int colorSelection = pref.getInt("COLOR_SELECTION", 0);

        binding.changeFont.setSelection(fontSelection);
        binding.changeSize.setSelection(sizeSelection);
        binding.changeColor.setSelection(colorSelection);
    }
}
