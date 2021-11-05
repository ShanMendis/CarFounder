package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCarMake;
    Button btnCarImage;
    Button btnHints;
    Button btnAL;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCarImage = findViewById(R.id.btnCarImage);
        btnCarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IdCarImage.class);
                startActivity(i);
            }
        });

        btnCarMake = findViewById(R.id.btnCarMake);
        btnCarMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),IdCarMake.class);
                startActivity(i);
            }
        });

        btnHints = findViewById(R.id.btnHints);
        btnHints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HintActivity.class);
                startActivity(i);
            }
        });

        btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        btnAL = findViewById(R.id.btnAL);
        btnAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AdvancedLevel.class);
                startActivity(i);
            }
        });
    }


}