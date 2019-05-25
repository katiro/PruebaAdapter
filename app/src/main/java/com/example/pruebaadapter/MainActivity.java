package com.example.pruebaadapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends Activity implements Serializable {

    private ArrayList<Estudiante> alumnos;
    private ListView lista;
    private EstudianteAdapter Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alumnos= new ArrayList<Estudiante>();
        llenarLista();
        Adapter = new EstudianteAdapter(this, alumnos);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(Adapter);
       // lista.setOnItemClickListener(this);
        ImageButton btnnuevo_registro;
        btnnuevo_registro = findViewById(R.id.btnAgregar);
        btnnuevo_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AgregarAlumno.class );
                startActivity(intent);
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long ID) {
                Estudiante estudiante = Adapter.getEstudiante(position);
                Intent intent = new Intent(MainActivity.this,EditarAlumno.class );
                intent.putExtra("estudiante", estudiante);
                intent.putExtra("posEs", position);
                startActivity(intent);


            }
        });


    }

    private void llenarLista(){
        alumnos.add(new Estudiante("Jose", "Aviles", "Masculino", "VA13029", "Sistemas"));
        alumnos.add(new Estudiante("Erick", "Flores", "Masculino", "FL15001", "Sistemas"));
        alumnos.add(new Estudiante("Kevin", "Rojas", "Masculino", "RM15056", "Sistemas"));
        alumnos.add(new Estudiante("Roberto", "Castro", "Femenino", "CM15056", "Sistemas"));
        alumnos.add(new Estudiante("Nelson", "Gochez", "Masculino", "GL15012", "Sistemas"));
    }







}
