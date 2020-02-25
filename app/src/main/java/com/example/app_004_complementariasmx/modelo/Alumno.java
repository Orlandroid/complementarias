package com.example.app_004_complementariasmx.modelo;

public class Alumno extends Persona {


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
}
