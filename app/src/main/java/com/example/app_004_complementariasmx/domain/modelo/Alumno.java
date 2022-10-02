package com.example.app_004_complementariasmx.domain.modelo;

import androidx.annotation.NonNull;

public class Alumno extends com.example.app_004_complementariasmx.domain.modelo.Persona {


    private String numeroDeControl;
    private int id_carrera;
    private int id_alumno;


    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNumeroDeControl() {
        return numeroDeControl;
    }

    public void setNumeroDeControl(String numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }

    public int getCarrera() {
        return id_carrera;
    }

    public void setCarrera(int carrera) {
        this.id_carrera = carrera;
    }

    @NonNull
    @Override
    public String toString() {
        return  String.format("%s %s %s %s %s %d",getNombre(),getSexo(),getaMaterno(),getaPaterno(),getNumeroDeControl(),getCarrera());
    }
}
