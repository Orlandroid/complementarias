package com.example.app_004_complementariasmx.presentacion.ui.alumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app_004_complementariasmx.R;

import java.util.ArrayList;

public class Alumnos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        RecyclerView recyclerViewAlumnos = findViewById(R.id.gridAlumnos);
        recyclerViewAlumnos.setLayoutManager(new GridLayoutManager(this, 1));

    }
}