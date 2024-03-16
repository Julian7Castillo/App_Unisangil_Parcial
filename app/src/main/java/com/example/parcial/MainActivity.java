package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed_Correo, ed_Pass;
    Button btn_Ingreso, btn_Registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_Correo = findViewById(R.id.ed_Correo);
        ed_Pass = findViewById(R.id.ed_Pass);
        btn_Ingreso = findViewById(R.id.btn_Ingreso);
        btn_Registro = findViewById(R.id.btn_Registro);

        btn_Ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickIngreso();
            }
        });

        btn_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRegistro();
            }
        });
    }

    private void onClickIngreso(){

        //Obtener texto de los campos
        String correo = ed_Correo.getText().toString();
        String clave = ed_Pass.getText().toString();

        if(!correo.isEmpty()){
            if(!clave.isEmpty()){
                if(correo.equals("usuario@gmail.com")&& clave.equals("P4ssw0rd")){
                    //mensaje de ingreso
                    Toast.makeText(this, "Ha iniciado sesion", Toast.LENGTH_SHORT).show();

                    //inicia sesion con normalidad
                    Intent inten = new Intent(MainActivity.this, HomeActivity.class);
                    inten.putExtra("correo", correo);
                    startActivity(inten);
                }
                else{
                    //mensaje de error al iniciar sesion
                    Toast.makeText(this, "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
            //en el caso de qeu la contraseña este vacia saldra el mensaje y lo mismo para el correo
            else{
                ed_Pass.setError("Campo de Contraseña vacio");
            }
        }
        else{
            ed_Correo.setError("Campo de correo vacio");
        }
    }
    private void onClickRegistro(){
        Intent inten = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(inten);
    }
}