package com.example.app_004_complementariasmx.presentacion.ui.menu;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.example.app_004_complementariasmx.R;
import com.example.app_004_complementariasmx.presentacion.ui.alumnos.Alumnos;


public class MenuPrincipal extends AppCompatActivity {


    public void click() {
        Intent intent = new Intent(this, Alumnos.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }
}
