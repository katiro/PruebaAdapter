package com.example.pruebaadapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import java.io.Serializable;

public class EditarAlumno extends AppCompatActivity implements Serializable{

    Estudiante estudiante;
    int posi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_alumno);
        estudiante = (Estudiante) getIntent().getSerializableExtra("estudiante");
        posi = (int) getIntent().getSerializableExtra("posicion");
        llenarCampos();
        //boton de guardar los cambios
        Button GuardarCambios;
        GuardarCambios = findViewById(R.id.agregar_edt);
        GuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
    }

    public void llenarCampos(){
        EditText txtNombre= findViewById(R.id.txtnombre_edt);
        txtNombre.setText(estudiante.getNombre());

        EditText txtApellido= findViewById(R.id.txtapellido_edt);
        txtApellido.setText(estudiante.getApellido());

        EditText txtCarrera= findViewById(R.id.txtcarrera_edt);
        txtCarrera.setText(estudiante.getCarrera());

        EditText txtCarnet= findViewById(R.id.txtcarnet_edt);
        txtCarnet.setText(estudiante.getCarnet());

        String sexo= estudiante.getSexo();

        if(sexo.equals("Masculino")){
            RadioButton btnMasc= findViewById(R.id.masculino);
            btnMasc.setChecked(true);
        }else{
            RadioButton btnFem= findViewById(R.id.femenino);
            btnFem.setChecked(true);
        }
    }

    public void guardarDatos(){
        EditText txtNombre= findViewById(R.id.txtnombre_edt);
        String nombre= txtNombre.getText().toString();

        EditText txtApellido= findViewById(R.id.txtapellido_edt);
        String apellido= txtApellido.getText().toString();

        EditText txtCarrera= findViewById(R.id.txtcarrera_edt);
        String carrera= txtCarrera.getText().toString();

        EditText txtCarnet= findViewById(R.id.txtcarnet_edt);
        String carnet= txtCarnet.getText().toString();

        String sexo;
        RadioButton btnMasc= findViewById(R.id.masculino);

        if(btnMasc.isChecked()){
            sexo="Masculino";
        }else{
            sexo="Femenino";
        }

        Estudiante editado= new Estudiante();
        editado.setId(estudiante.getId());
        editado.setNombre(nombre);
        editado.setApellido(apellido);
        editado.setCarrera(carrera);
        editado.setCarnet(carnet);
        editado.setSexo(sexo);
        Intent intent = new Intent(EditarAlumno.this, MainActivity.class );
        intent.putExtra("editado", editado);
        intent.putExtra("posi",posi);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
