package com.example.pruebaadapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;

public class AgregarAlumno extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_alumno);

        //boton de agregar
        Button agregar;
        agregar = findViewById(R.id.agregarNv);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos();
            }
        });
    }


    private void obtenerDatos(){
        EditText txtNombre= findViewById(R.id.txtagregarNv);
        String nombre= txtNombre.getText().toString();
        EditText txtApellido= findViewById(R.id.txtapellidoNv);
        String apellido= txtApellido.getText().toString();
        EditText txtCarrera= findViewById(R.id.txtcarreraNv);
        String carrera= txtCarrera.getText().toString();
        EditText txtCarnet= findViewById(R.id.txtcarnetNv);
        String carnet= txtCarnet.getText().toString();
        RadioButton btnMasc= findViewById(R.id.masculino);
        RadioButton btnFem= findViewById(R.id.femenino);
        String sexo="Indefinido";
        if(btnMasc.isChecked()){
            sexo="Masculino";
        }else if(btnFem.isChecked()){
            sexo="Femenino";
        }

        Estudiante nuevo= new Estudiante();

        if(nombre.equalsIgnoreCase("") || apellido.equalsIgnoreCase("")
                || carnet.equalsIgnoreCase("") || sexo.equalsIgnoreCase("Indefinido")
                || carrera.equalsIgnoreCase("")){
            AlertDialog alerta= new AlertDialog.Builder(AgregarAlumno.this)
                    .setMessage("Se deben llenar todos los campos").create();
            alerta.show();
        }else {
            nuevo.setNombre(nombre);
            nuevo.setApellido(apellido);
            nuevo.setSexo(sexo);
            nuevo.setCarnet(carnet);
            nuevo.setCarrera(carrera);
            Intent intent = new Intent(AgregarAlumno.this, MainActivity.class);
            intent.putExtra("nuevo", nuevo);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }


    }




}
