package com.example.lr4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lr4.fragments.EmployeeFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().
                beginTransaction().
                add(R.id.main_fragment, new EmployeeFragment(), "user_fragment").
                commit();
    }
}