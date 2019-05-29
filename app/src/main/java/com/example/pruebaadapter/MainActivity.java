package com.example.pruebaadapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private Estudiante estudiante = new Estudiante();
    private Estudiante estudianteNV = new Estudiante();
    private int posicion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alumnos =  new ArrayList<Estudiante>();
        llenarLista();

        //adaptador
        Adapter = new EstudianteAdapter(this, alumnos);
        lista = (ListView) findViewById(R.id.lista);

        //enviar el adaptador al listView
        lista.setAdapter(Adapter);

        agregar();
        editar();
        eliminar();
    }

    private void llenarLista(){
        alumnos.add(new Estudiante(1,"Jose", "Aviles", "Masculino", "VA13029", "Sistemas"));
        alumnos.add(new Estudiante(2,"Erick", "Flores", "Masculino", "FL15001", "Sistemas"));
        alumnos.add(new Estudiante(3,"Kevin", "Rojas", "Masculino", "RM15056", "Sistemas"));
        alumnos.add(new Estudiante(4,"Roberto", "Castro", "Femenino", "CM15056", "Sistemas"));
        alumnos.add(new Estudiante(5,"Nelson", "Gochez", "Masculino", "GL15012", "Sistemas"));
    }

    private void agregar(){
        ImageButton btnnuevo_registro;
        btnnuevo_registro = findViewById(R.id.btnAgregar);
        btnnuevo_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AgregarAlumno.class );
                startActivityForResult(intent,1);
            }
        });
    }

    private void editar(){
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long ID) {
                Estudiante estudiante = Adapter.getEstudiante(position);
                Intent intent = new Intent(MainActivity.this,EditarAlumno.class );
                intent.putExtra("estudiante", estudiante);
                intent.putExtra("posicion",position);
                startActivityForResult(intent,1);
            }
        });
    }

    private void eliminar(){
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Estudiante estudiante = Adapter.getEstudiante(position);

                AlertDialog alerta= new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Eliminar Registro")
                        .setIcon(0).setMessage("Se eliminará el registro")
                        .setNeutralButton(R.string.aceptar,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int i) {
                                        alumnos.remove(estudiante);
                                        Adapter.notifyDataSetChanged();
                                    }
                                }).setNegativeButton(R.string.cancelar,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                    }
                                }
                        ).create();
                alerta.show();
                return true;
            }
        });



    }

    //metodo que recibira las respuestas de las demas actividades
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            estudiante = (Estudiante) data.getSerializableExtra("editado");
            estudianteNV= (Estudiante) data.getSerializableExtra("nuevo");

            if(estudiante!=null) {
                posicion = (int) data.getSerializableExtra("posi");
                alumnos.set(posicion, estudiante);
                AlertDialog alerta= new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Estudiante editado con éxito").create();
                alerta.show();
            }
            else if(estudianteNV!=null){
                alumnos.add(estudianteNV);
                AlertDialog alerta= new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Estudiante agregado con éxito").create();
                alerta.show();
            }
                Adapter.notifyDataSetChanged();
        }
    }
}



