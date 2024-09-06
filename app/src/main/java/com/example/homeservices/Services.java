package com.example.homeservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Services extends AppCompatActivity {
    String[] types={"Plumber","Electrician","Cable Operator","TV","WIFI","PEST CONTROL"};
    int[] index={0,1,2,3,4,5};

    ImageView plumber_ser,electric,cabeloperator,wifi,doctor,transport;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        plumber_ser=findViewById(R.id.plumber_service);
        electric=findViewById(R.id.electrician_service);
        cabeloperator=findViewById(R.id.cable_service);
        wifi=findViewById(R.id.wifi_service);
        doctor=findViewById(R.id.doctor_service);
        transport=findViewById(R.id.transport_service);
        plumber_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Services.this,ServiceProviders.class);
                i.putExtra("CHOSEN","0");
                startActivity(i);
            }
        });
        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Services.this,ServiceProviders.class);
                i.putExtra("CHOSEN","1");
                startActivity(i);
            }
        });
        cabeloperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Services.this,ServiceProviders.class);
                i.putExtra("CHOSEN","2");
                startActivity(i);
            }
        });
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Services.this,ServiceProviders.class);
                i.putExtra("CHOSEN","3");
                startActivity(i);
            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Services.this,ServiceProviders.class);
                i.putExtra("CHOSEN","4");
                startActivity(i);
            }
        });
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Services.this,ServiceProviders.class);
                i.putExtra("CHOSEN","5");
                startActivity(i);
            }
        });

    }
}



