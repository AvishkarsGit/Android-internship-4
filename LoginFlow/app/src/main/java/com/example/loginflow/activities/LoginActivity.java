package com.example.loginflow.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginflow.MainActivity;
import com.example.loginflow.R;

public class LoginActivity extends AppCompatActivity {


    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    private String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        //component init
        initComponent();


        //handle login
        btnLogin.setOnClickListener(v-> {
            if (validateLogin()) {
                //login handling
                login();
            }
        });


    }

    private void initComponent() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private boolean validateLogin() {
        username = edtUsername.getText().toString().trim();
        password  = edtPassword.getText().toString().trim();
        if (username.isEmpty()) {
            Toast.makeText(this, "User name is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (password.isEmpty()) {
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {

            return true;
        }
    }


    private void login() {
        if (username.equals("admin") && password.equals("admin@123")) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            setLogin();
        }
        else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private void setLogin() {
        SharedPreferences preferences = getSharedPreferences("LoginFlow",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn",true);
        editor.apply();

    }

    private boolean checkLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("LoginFlow",MODE_PRIVATE);
        boolean login = preferences.getBoolean("isLoggedIn",false);
        Toast.makeText(this, ""+login, Toast.LENGTH_LONG).show();
        return login;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart() call", Toast.LENGTH_LONG).show();
        if (checkLoggedIn()) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            this.finish();
        }
    }
}