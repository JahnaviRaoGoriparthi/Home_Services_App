package com.example.homeservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
        import android.annotation.SuppressLint;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
import android.view.View;
        import android.widget.Button;
import android.widget.TextView;

public class Endpage extends AppCompatActivity {
    Button btnCongrats;
    TextView t1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endpage);

        btnCongrats = findViewById(R.id.btn_congrats);
        t1=findViewById(R.id.thank);

        btnCongrats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Endpage.this);
                builder.setMessage("Kindly Visit Again :)")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Close the dialog
                                dialog.dismiss();
                                finishAffinity();
                                System.exit(0);

                            }
                        });

                // Show the dialog
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}