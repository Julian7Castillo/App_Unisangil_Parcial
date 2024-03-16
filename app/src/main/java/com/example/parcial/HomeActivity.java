package com.example.parcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    ImageView img_Logo;
    TextView tw_correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        img_Logo = findViewById(R.id.img_Logo);
        tw_correo = findViewById(R.id.tw_correo);

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/primer-proyecto-b27bf.appspot.com/o/descarga.png?alt=media&token=25c46eb9-55a2-4c48-a31e-31198e8874d2 ").
                placeholder(R.drawable.cargando).
                error(R.drawable.error).
                into(img_Logo);

        Intent intent = getIntent();
        String correo = intent.getStringExtra("correo");

        tw_correo.setText(correo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //opciones del menu superior
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();

        if(idItem == R.id.itemCerrarSesion){
            clickCerrarSesion();

        }else if (idItem == R.id.itemNosotros) {
            clickNosotros();
        }

        return super.onOptionsItemSelected(item);
    }

    //funciones del menu
    private void clickNosotros(){
        MensajeToast("Click en Nosotros");
        Intent inten = new Intent(HomeActivity.this, NosotrosActivity.class);
        startActivity(inten);
    }

    private void clickCerrarSesion(){
        MensajeToast("cerro sesion");
        Intent inten = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(inten);
    }

    //Mensaje de salida
    private void MensajeToast(String mensaje){
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}