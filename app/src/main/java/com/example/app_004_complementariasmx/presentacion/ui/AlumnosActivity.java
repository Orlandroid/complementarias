package com.example.app_004_complementariasmx.presentacion.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.app_004_complementariasmx.R;
import com.example.app_004_complementariasmx.domain.modelo.Alumno;


public class AlumnosActivity extends AppCompatActivity {
    Alumno alumno;


    private void limpiarTxt(EditText[] datos) {
        for (EditText text : datos)
            text.setText(null);
    }

    private boolean validarTxt(EditText[] datos) {
        for (EditText txt : datos) {
            if (txt.getText().toString().equals("")) {
                txt.setError("Campo requerido");
                return false;
            }
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_new_edit);
    }
}
