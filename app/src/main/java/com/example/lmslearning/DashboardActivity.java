package com.example.lmslearning;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class DashboardActivity extends AppCompatActivity {
    public  Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DashboardActivity.this,YearOneNotesActivity.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DashboardActivity.this,YearTwoNotesActivity.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DashboardActivity.this,YearThreeNotesActivity.class);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DashboardActivity.this,YearFourNotesActivity.class);
                startActivity(intent);
            }
        });

//
//    public void startActivity(Intent intent) {
    }
}


