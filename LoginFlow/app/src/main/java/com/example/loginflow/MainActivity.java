package com.example.loginflow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginflow.activities.LoginActivity;

public class MainActivity extends AppCompatActivity {



    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //init
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(v-> {
            //logout;
            logout();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        });



    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences("LoginFlow",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn",false);
        editor.apply();
    }
}

