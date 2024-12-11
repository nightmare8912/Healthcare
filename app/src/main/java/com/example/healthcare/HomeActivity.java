package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    CardView cvLabTest, cvBuyMedicine, cvFindDoctor, cvHealthArticles, cvOrderDetails, cvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // getting info from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        Toast.makeText(getApplicationContext(), "Welcome " + username + "!", Toast.LENGTH_SHORT).show();

        // loading all the controls in appropriate variables
        cvLabTest = findViewById(R.id.cardViewLabTest);
        cvBuyMedicine = findViewById(R.id.cardViewBuyMedicine);
        cvFindDoctor = findViewById(R.id.cardViewFindDoctor);
        cvHealthArticles = findViewById(R.id.cardViewHealthArticles);
        cvOrderDetails = findViewById(R.id.cardViewOrderDetails);
        cvLogout = findViewById(R.id.cardViewLogout);

        // all fn calls when a card view is clicked is done below
        cvLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvLabTest(v);
            }
        });
        cvBuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvBuyMedicine(v);
            }
        });
        cvFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvFindDoctor(v);
            }
        });
        cvHealthArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvHealthArticles(v);
            }
        });
        cvOrderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvOrderDetails(v);
            }
        });
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvLogout(v, sharedPreferences);
            }
        });
    }

    private void onClickCvLabTest(View v) {
        // when labtest is clicked
    }

    private void onClickCvBuyMedicine(View v) {
        // when buymedicine is clicked
    }

    private void onClickCvFindDoctor(View v) {
        // when find doctor is clicked
        startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class ));
    }

    private void onClickCvHealthArticles(View v) {
        // when healtharticles is clicked
    }

    private void onClickCvOrderDetails(View v) {
        // when orderdetails is clicked
    }

    private void onClickCvLogout(View v, SharedPreferences sharedPreferences) {
        // when logout is clicked
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
    }
}