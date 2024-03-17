package com.example.parcial_sebastian_montoya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edCorreoLg, edContrasenaLg;
    Button btnIngreso, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCorreoLg = findViewById(R.id.edCorreoLg);
        edContrasenaLg = findViewById(R.id.edContrasenaLg);

        btnIngreso = findViewById(R.id.btnIngreso);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton_ingreso();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClicRegistro();
            }
        });
    }

    public void boton_ingreso() {
        String correo = edCorreoLg.getText().toString();
        String contra = edContrasenaLg.getText().toString();

        if (correo.isEmpty() || contra.isEmpty()) {
            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        } else {
            ClicIngreso();
        }
    }

    private void ClicIngreso() {
        String nombreUsuario = edCorreoLg.getText().toString();
        Intent intent = new Intent(this, BienvenidaActivity.class);
        intent.putExtra("nombreUsuario", nombreUsuario);
        startActivity(intent);
    }

    private void ClicRegistro() {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}
