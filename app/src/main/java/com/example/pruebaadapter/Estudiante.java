package com.example.pruebaadapter;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private String nombre, apellido, sexo, carnet, carrera;

    public Estudiante(){
    }

    public Estudiante(String nombre, String apellido, String sexo, String carnet, String carrera){
        this.nombre=nombre;
        this.apellido=apellido;
        this.sexo=sexo;
        this.carnet=carnet;
        this.carrera=carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
