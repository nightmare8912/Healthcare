package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btnLogin;
    TextView tvNewUser;
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

        // mapping the controls to java, this is like document.findElementById("id") in html/js
        edUsername = findViewById(R.id.editTextUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btnLogin = findViewById(R.id.buttonCreate);
        tvNewUser = findViewById(R.id.textViewNewUser);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onLoginClick(v);
            }
        });

        tvNewUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onCreateAccountClick(v);
            }
        });
    }

    public void onLoginClick(View v) {
        // this fn runs when login button is clicked
        // getting the data
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();

        // checking if either of them is empty
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            if (db.loginUser(username, password) == 0) {
                Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Welcome " + username + "!", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.apply();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        }
    }

    public void onCreateAccountClick(View v) {
        // this fn runs when create-account button is clicked
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}