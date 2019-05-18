package com.example.pruebaadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnItemClickListener {

    private ArrayList<Estudiante> alumnos;
    private ListView lista;
    private EstudianteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alumnos= new ArrayList<Estudiante>();
        llenarLista();
        adapter = new EstudianteAdapter(this, alumnos);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);


    }

    private void llenarLista(){
        alumnos.add(new Estudiante("Jose", "Aviles", "Masculino", "VA13029", "Sistemas"));
        alumnos.add(new Estudiante("Erick", "Flores", "Masculino", "FL15001", "Sistemas"));
        alumnos.add(new Estudiante("Kevin", "Rojas", "Masculino", "RM15056", "Sistemas"));
        alumnos.add(new Estudiante("Roberto", "Castro", "Femenino", "CM15056", "Sistemas"));
        alumnos.add(new Estudiante("Nelson", "Gochez", "Masculino", "GL15012", "Sistemas"));
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position,
                            long ID) {
        // Al hacer click sobre uno de los items del ListView mostramos los
        // datos en los TextView.
        //tvNombre.setText(animales.get(position).getNombre());
        //tvNumCelda.setText(String.valueOf(position));

    }



}
