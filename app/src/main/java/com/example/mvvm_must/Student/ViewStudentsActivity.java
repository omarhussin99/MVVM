package com.example.mvvm_must.Student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.mvvm_must.R;

import java.util.ArrayList;
import java.util.List;

public class ViewStudentsActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        init();
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerView);

        List<Employee> employeeList = new ArrayList<>();

        //Todo : get all students from the database

        EmployeesAdapter employeesAdapter = new EmployeesAdapter(employeeList,this);
        recyclerView.setAdapter(employeesAdapter);

    }
}
