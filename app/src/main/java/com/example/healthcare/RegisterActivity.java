package com.example.healthcare;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirmPassword;
    Button btnCreate;
    TextView tvAlreadyHaveAnAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // loading all the values in variables
        edUsername = findViewById(R.id.editTextUsername);
        edEmail = findViewById(R.id.editTextEmail);
        edPassword = findViewById(R.id.editTextLoginPassword);
        edConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        btnCreate = findViewById(R.id.buttonCreate);
        tvAlreadyHaveAnAccount = findViewById(R.id.textViewAlreadyHaveAnAccount);

        // adding listeners
        btnCreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 onClickBtnCreate(v);
            }
        });

        tvAlreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAlreadyHaveAnAccount(v);
            }
        });
    }

    public void onClickBtnCreate(View v) {
        // this fn is called when Create button is clicked
        String username, email, password, confirmPassword;

        username = edUsername.getText().toString();
        email = edEmail.getText().toString();
        password = edPassword.getText().toString();
        confirmPassword = edConfirmPassword.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            // when one or more fields are empty
            Toast.makeText(getApplicationContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
        } else {
            if (!password.equals(confirmPassword)) {
                // when both password and confirm password are not same
                Toast.makeText(getApplicationContext(), "Password and Confirm password don't match", Toast.LENGTH_SHORT).show();
            } else {
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.registerNewUser(username, email, password);
                Toast.makeText(getApplicationContext(), "Account created successfully for user: " + username, Toast.LENGTH_SHORT).show();
                // we now redirect to LoginActivity
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        }
    }

    public void onClickAlreadyHaveAnAccount(View v) {
        // this fn is called when already have an account is clicked
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}