package com.example.mvvm_must;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvm_must.Utils.UtilsFunctions;

public class LoginActivity extends AppCompatActivity {
    public EditText usernameED;
    EditText passwordED;
    Button loginTV;
    boolean isLoggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameED = findViewById(R.id.username_ED);
        passwordED = findViewById(R.id.password_ED);
        loginTV = findViewById(R.id.acsses);
        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usernameED.getText().toString().trim().equals("") && !passwordED.getText().toString().trim().equals(""))
                    login(usernameED.getText().toString().trim(), passwordED.getText().toString().trim());
                else
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(String username, String password) {

        // TODO: search for username and password

        if (username.equals("admin") && password.equals("admin")) {
            isLoggedIn = true;
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
            finishAffinity();
            UtilsFunctions.saveToSharedPref(this, username);

        } else {
            for (Employee employee : employeeList) {
                if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                    Intent intent = new Intent(this, WelcomeActivity.class);
                    startActivity(intent);
                    finishAffinity();
                    UtilsFunctions.saveToSharedPref(this, username);
                    isLoggedIn = true;
                }
            }
            if (!isLoggedIn) {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        }
    }
}
