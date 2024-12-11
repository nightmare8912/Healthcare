package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DoctorDetailsActivity extends AppCompatActivity {
    TextView tvTitle;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // loading the variables
        tvTitle = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.buttonBack);

        // setting the title
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tvTitle.setText(title);

        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onClickBtnBack(v);
            }
        });
    }

    public void onClickBtnBack(View v) {
        startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
    }
}