 package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {

    CardView cvFamilyPhysicians, cvDieticians, cvDentists, cvSurgeons, cvCardiologists, cvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // loading all the controls in appropriate variables
        cvFamilyPhysicians = findViewById(R.id.cardViewFDFamilyPhysicians);
        cvDieticians = findViewById(R.id.cardViewFDDieticians);
        cvDentists = findViewById(R.id.cardViewFDDentists);
        cvSurgeons = findViewById(R.id.cardViewFDSurgeons);
        cvCardiologists = findViewById(R.id.cardViewFDCardiologists);
        cvBack = findViewById(R.id.cardViewFDDBack);

        // all fn calls when a card view is clicked is done below
        cvFamilyPhysicians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvFamilyPhysicians(v);
            }
        });
        cvDieticians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvDieticians(v);
            }
        });
        cvDentists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvDentists(v);
            }
        });
        cvSurgeons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvSurgeons(v);
            }
        });
        cvCardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvCardiologists(v);
            }
        });
        cvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCvBack(v);
            }
        });
    }

    private void onClickCvFamilyPhysicians(View v) {
        // when family physician is clicked
        Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        it.putExtra("title", "Family Physicians");
        startActivity(it);
    }

    private void onClickCvDieticians(View v) {
        // when dieticians is clicked
        Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        it.putExtra("title", "Dieticians");
        startActivity(it);
    }

    private  void onClickCvDentists(View v) {
        // when dentists is clicked
        Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        it.putExtra("title", "Dieticians");
        startActivity(it);
    }

    private void onClickCvSurgeons(View v) {
        // when surgeons is clicked
        Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        it.putExtra("title", "Surgeons");
        startActivity(it);
    }

    private void onClickCvCardiologists(View v) {
        // when cardiologists is clicked
        Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        it.putExtra("title", "Cardiologists");
        startActivity(it);
    }

    private void onClickCvBack(View v) {
        // when back is clicked
        startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
    }
}