package com.example.parcial_sebastian_montoya;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import android.app.AlertDialog;
import android.app.DatePickerDialog;

import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.content.Intent;

import android.view.View;


import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.Toast;

import android.os.Bundle;

public class RegistroActivity extends AppCompatActivity {

    EditText edNombreReg, edCorreoReg, edDireccionReg, edTelefonoReg, edCumpleReg, edContraReg;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edNombreReg = findViewById(R.id.edNombreReg);
        edCorreoReg = findViewById(R.id.edCorreoReg);
        edDireccionReg = findViewById(R.id.edDireccionReg);
        edTelefonoReg = findViewById(R.id.edTelefonoReg);
        edCumpleReg = findViewById(R.id.edCumpleReg);
        edContraReg = findViewById(R.id.edContraReg);

        btnRegistro = findViewById(R.id.btnRegistro);

        edCumpleReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    public void boton_registro(View view) {

        String nombre = edNombreReg.getText().toString();
        String correo = edCorreoReg.getText().toString();
        String direccion =  edDireccionReg.getText().toString();
        String telefono = edTelefonoReg.getText().toString();
        String cumple = edCumpleReg.getText().toString();
        String contra = edContraReg.getText().toString();


        if (nombre.isEmpty() || correo.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || cumple.isEmpty() || contra.isEmpty()) {

            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        } else {
            Registro();

        }
    }

    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(RegistroActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edCumpleReg.setText(year + "-" + (month+1) + "-" + dayOfMonth);
            }
        },year,month,dayOfMonth);
        dialog.show();
    }

    private void Registro(){

        AlertDialog.Builder alert = new AlertDialog.Builder(RegistroActivity.this);
        alert.setTitle("¿Sus datos son correctos?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String nombreUsuario = edNombreReg.getText().toString();
                        Intent intent = new Intent(RegistroActivity.this, BienvenidaActivity.class);
                        intent.putExtra("nombreUsuario", nombreUsuario);

                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RegistroActivity.this, "Click en No", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

}