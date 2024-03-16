package com.example.parcial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText ed_Nombre,ed_Correo,ed_Direccion,ed_Telefono, ed_Cumpleanios,ed_Contra1, ed_Contra2;

    Button btn_Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ed_Nombre = findViewById(R.id.ed_Nombre);
        ed_Correo = findViewById(R.id.ed_Correo);
        ed_Direccion = findViewById(R.id.ed_Direccion);
        ed_Telefono = findViewById(R.id.ed_Telefono);
        ed_Cumpleanios = findViewById(R.id.ed_Cumpleanios);
        ed_Contra1 = findViewById(R.id.ed_Contra1);
        ed_Contra2 = findViewById(R.id.ed_Contra2);
        btn_Enviar = findViewById(R.id.btn_Enviar);

        ed_Cumpleanios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalendar();
            }
        });

        btn_Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickEnviar();
            }
        });
    }

    private  void onClickEnviar(){

        //Obtener texto de los campos
        String nombre = ed_Nombre.getText().toString();
        String correo = ed_Correo.getText().toString();
        String Direccion = ed_Direccion.getText().toString();
        String Telefono = ed_Telefono.getText().toString();
        String Cumple = ed_Cumpleanios.getText().toString();
        String clave1 = ed_Contra1.getText().toString();
        String clave2 = ed_Contra2.getText().toString();

        if(!nombre.isEmpty()){
            if (!correo.isEmpty()){
                if (!Direccion.isEmpty()){
                    if (!Telefono.isEmpty()){
                        if(!Cumple.isEmpty()){
                            if (!clave1.isEmpty()){
                                if (!clave2.isEmpty()){
                                    if (!clave1.equals(clave2)){
                                        //mensaje de validacion de ocntraseñas igualales
                                        Toast.makeText(this, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show();
                                    } else {
                                        AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                                        alert.setTitle("Confirmar").setMessage("¿Sus datos son Correctos? ").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Toast.makeText(RegisterActivity.this, "Datos Guardados correctamente", Toast.LENGTH_SHORT).show();
                                                        Intent inten = new Intent(RegisterActivity.this, HomeActivity.class);
                                                        inten.putExtra("correo", correo);
                                                        startActivity(inten);
                                                    }
                                                })
                                                .setNegativeButton("No", null)
                                                .setCancelable(false).show()
                                                .setIcon(R.drawable.cargando);
                                    }
                                }else{
                                    ed_Contra2.setError("Campo de confirmacion de contraseña vacio");
                                }
                            }else{
                                ed_Contra1.setError("Campo de contraseña vacio");
                            }
                        }else{
                            ed_Cumpleanios.setError("Campo de cumpleaños vacio");
                        }
                    }else{
                        ed_Telefono.setError("Campo de Telefono vacio");
                    }
                }else{
                    ed_Direccion.setError("Campo de Dirección vacio");
                }
            }else{
                ed_Correo.setError("Campo de correo vacio");
            }
        }else{
            ed_Nombre.setError("Campo de Nombre vacio");
        }
    }

    private void showCalendar(){
        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int dayOfMonth = calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ed_Cumpleanios.setText(year+" - "+(month+1)+" - "+dayOfMonth);
            }
        },year, month, dayOfMonth);
        dialog.show();
    }
}