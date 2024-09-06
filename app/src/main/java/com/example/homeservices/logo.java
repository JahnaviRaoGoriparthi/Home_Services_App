package com.example.homeservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

public class logo extends AppCompatActivity {

    private ImageView photoImageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        photoImageView = findViewById(R.id.photo_imageview);

        // Wait for 5 seconds before translating text
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                translateText();
            }
        }, 3000);
    }

    private void translateText() {
        // TODO: Add code to translate text

        // Open the login page
        Intent intent = new Intent(logo.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}