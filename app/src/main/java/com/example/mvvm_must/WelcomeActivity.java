package com.example.mvvm_must;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvm_must.Utils.UtilsFunctions;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    TextView editTv;
    TextView insertTv;
    TextView tvAllEmployees;
    TextView tvUsername;
    Button logout_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        editTv = findViewById(R.id.edit_departmen_Tv);
        tvUsername = findViewById(R.id.tvUsername);
        insertTv = findViewById(R.id.insert_employee);
        tvAllEmployees = findViewById(R.id.tvAllEmployees);
        logout_Btn = findViewById(R.id.logout_Btn);


        tvUsername.setText(getString(R.string.welcome_omar, UtilsFunctions.getNameFromSharedPref(this)));

        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WelcomeActivity.this, EditDepartmentActivity.class);
            }
        });
        insertTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Department_item> Department_item = new ArrayList<>();

                //TODO: Check for availability of collage

                if(Department_item.size()!= 0){
                startActivity(WelcomeActivity.this, InsertEmployee.class);
                }
                else{
                    Toast.makeText(WelcomeActivity.this, "Please add a department", Toast.LENGTH_SHORT).show();
                }
            }

        });
        tvAllEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(WelcomeActivity.this, ViewEmployeesActivity.class);
            }
        });

        logout_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilsFunctions.removeAll(WelcomeActivity.this);

                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }


    void startActivity(Context context, Class<?> aClass) {
        Intent intent = new Intent(context, aClass);
        startActivity(intent);
    }
}
