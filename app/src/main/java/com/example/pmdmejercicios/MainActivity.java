package com.example.pmdmejercicios;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbrirCalculadora = findViewById(R.id.btnAbrirCalculadora);

        // Usamos un listener estándar para navegar de una actividad a otra[cite: 14, 18]
        btnAbrirCalculadora.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            startActivity(intent);
        });
    }
}
