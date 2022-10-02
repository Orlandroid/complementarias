package com.example.app_004_complementariasmx.presentacion.ui.alumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app_004_complementariasmx.R;
import com.example.app_004_complementariasmx.domain.modelo.Alumno;

import java.util.ArrayList;

public class Alumnos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        RecyclerView recyclerViewAlumnos = findViewById(R.id.gridAlumnos);

        ArrayList<Alumno> ListaAlumnos = new ArrayList<>();
        Alumno alumno = new Alumno();
        alumno.setNombre("Guadalupe");
        alumno.setSexo("Hombre");
        alumno.setaMaterno("Diaz");
        alumno.setaPaterno("Lopez");
        alumno.setNumeroDeControl("15060100");
        alumno.setCarrera(1);
        ListaAlumnos.add(alumno);


        AdaptadorAlumno adaptador = new AdaptadorAlumno(ListaAlumnos);
        recyclerViewAlumnos.setAdapter(adaptador);
        recyclerViewAlumnos.setLayoutManager(new GridLayoutManager(this, 1));

    }
}