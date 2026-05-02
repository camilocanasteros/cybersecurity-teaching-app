package com.example.ns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        ImageView phishing = findViewById(R.id.imageView9);
        ImageView malware = findViewById(R.id.imageView12);
        ImageView ransomware = findViewById(R.id.imageView10);
        ImageView whaling = findViewById(R.id.imageView11);
        ImageView inyeccion = findViewById(R.id.imageView13);
        ImageView tips = findViewById(R.id.imageView14);
        ImageView mas = findViewById(R.id.imageView16);

        TextView txtNombre = findViewById(R.id.textView);

        String nombre = getIntent().getStringExtra("nombre");

        txtNombre.setText("Bienvenido " + nombre);
        phishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Phishing.class);
                startActivity(intent);
            }
        });

        malware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Malware.class);
                startActivity(intent);
            }
        });

        ransomware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Randomware.class);
                startActivity(intent);
            }
        });

        whaling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Whaling.class);
                startActivity(intent);
            }
        });

        inyeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inyeccion.class);
                startActivity(intent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Tips.class);
                startActivity(intent);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Mas.class);
                startActivity(intent);
            }
        });
    }
}