package com.example.pruebaadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EstudianteAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Estudiante> datos;

    public EstudianteAdapter(Context context, ArrayList<Estudiante> datos) {
        super(context, R.layout.activity_editar, datos);
        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item= inflater.inflate(R.layout.activity_editar, null);

        TextView nombre= item.findViewById(R.id.txtNombre);
        nombre.setText(datos.get(position).getNombre());

        TextView apellido= item.findViewById(R.id.txtApellido);
        apellido.setText(datos.get(position).getApellido());

        TextView sexo= item.findViewById(R.id.txtSexo);
        sexo.setText(datos.get(position).getSexo());

        TextView carnet= item.findViewById(R.id.txtCarnet);
        carnet.setText(datos.get(position).getCarnet());

        TextView carrera= item.findViewById(R.id.txtCarrera);
        carrera.setText(datos.get(position).getCarrera());

        return item;
    }

    public Estudiante getEstudiante(int posicion){
        Estudiante estudiante = datos.get(posicion);
        return estudiante;
    }





}
