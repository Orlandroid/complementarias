package com.example.app_004_complementariasmx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.app_004_complementariasmx.controlador.AlumnoC;
import com.example.app_004_complementariasmx.modelo.Alumno;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlumnosActivity extends AppCompatActivity {
    Alumno alumno;

    @BindView(R.id.alTxtNombre)
    EditText txtNombre;
    @BindView(R.id.alSpinerGenero)
    Spinner spinnerGenero;
    @BindView(R.id.alTxtApaterno)
    EditText txtApaterno;
    @BindView(R.id.alTxtAmaterno)
    EditText txtAmaterno;
    @BindView(R.id.alTxtNumeroControl)
    EditText txtNumeroControl;
    @BindView(R.id.alSpinnerCarrera)
    Spinner spinnerCarrera;
    @BindView(R.id.alBtnRegistrar)
    Button btnRegitrar;

    @OnClick(R.id.alBtnRegistrar)
    public void click() {
        alumno = new Alumno();
        alumno.setNombre(txtNombre.getText().toString());
        alumno.setSexo(spinnerGenero.getSelectedItem().toString());
        alumno.setaMaterno(txtAmaterno.getText().toString());
        alumno.setaPaterno(txtApaterno.getText().toString());
        alumno.setNumeroDeControl(txtNumeroControl.getText().toString());
        alumno.setCarrera(spinnerCarrera.getSelectedItemPosition() + 1);
        AlumnoC alumnoC = new AlumnoC(alumno, getApplicationContext());
        alumnoC.registrarAlumno();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        ButterKnife.bind(this);
    }
}
