package com.example.parcial_sebastian_montoya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class BienvenidaActivity extends AppCompatActivity {

    ImageView ImagenIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        ImagenIngreso = findViewById(R.id.ImagenIngreso);

        Picasso.get().
                load("https://firebasestorage.googleapis.com/v0/b/primer-proyecto-b27bf.appspot.com/o/descarga.png?alt=media&token=25c46eb9-55a2-4c48-a31e-31198e8874d2").
                placeholder(R.drawable.carga).
                error(R.drawable.error).
                into(ImagenIngreso);

        TextView textoIngreso = findViewById(R.id.TextoIngreso);
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        String mensajeBienvenida = "¡Bienvenido, " + nombreUsuario + "!";
        textoIngreso.setText(mensajeBienvenida);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusuperior,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int idItem = item.getItemId();
        if (idItem == R.id.itemCerrarSesion){
            ClickItemCerrar();
        } else if (idItem == R.id.itemNosotros){
            clickItemNosotros();
        }
        return super.onOptionsItemSelected(item);
    }

    private void ClickItemCerrar(){
        Toast.makeText(this, "Cerrar Sesión", Toast.LENGTH_SHORT).show();
    }

    private void clickItemNosotros(){
        Toast.makeText(this, "Nosotros", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this,NosotrosActivity.class);
        startActivity(intent);
    }
}