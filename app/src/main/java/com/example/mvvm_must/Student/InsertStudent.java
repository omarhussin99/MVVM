package com.example.mvvm_must.Student;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mvvm_must.R;
import com.example.mvvm_must.Utils.UtilsFunctions;

import java.util.ArrayList;
import java.util.List;

public class InsertStudent extends AppCompatActivity {
    EditText id_Ed;
    EditText username;
    EditText password;
    RadioButton radioBtn;
    RadioGroup gender;
    Spinner spinner;
    Button submitBtn;
    List<Employee> employeeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);
        id_Ed = findViewById(R.id.id);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        gender = findViewById(R.id.gender);
        spinner = findViewById(R.id.spinner_list);
        submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!id_Ed.getText().toString().equals("") && !username.getText().toString().equals("") &&
                        !password.getText().toString().equals("")) {
                    insertEmployee();

                } else {
                    Toast.makeText(InsertStudent.this, "Please fill all data!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        List<Department_item> Department_item = new ArrayList<>();

        //Todo: check for availability of collage

        List<String> strings = new ArrayList<>();
        for (Department_item departmentItem : Department_item) {
            strings.add(departmentItem.getDepartment_name());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, strings);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

    }


    @SuppressLint("NewApi")
    public void insertEmployee() {
        String text_department = "";
        int selectedId = gender.getCheckedRadioButtonId();
        radioBtn = findViewById(selectedId);
        if (spinner.getSelectedItem() != null) {
            text_department = spinner.getSelectedItem().toString();
        }


        Employee employee = new Employee(id_Ed.getText().toString(), username.getText().toString(),
                password.getText().toString(), radioBtn.getText().toString(), text_department);

        //Todo: add a student to the database


        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
        id_Ed.setText("");
        username.setText("");
        password.setText("");
        id_Ed.requestFocus();
        UtilsFunctions.hideSoftKeyboard(InsertStudent.this);


    }
}
