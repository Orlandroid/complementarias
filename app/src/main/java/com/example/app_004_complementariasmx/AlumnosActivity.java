package com.example.app_004_complementariasmx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


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
    @BindView(R.id.alTxtId)
    EditText txtId;
    @BindView(R.id.alSpinnerCarrera)
    Spinner spinnerCarrera;
    @BindView(R.id.alBtnRegistrar)
    Button btnRegitrar;

    private EditText[] regresarArregloEditText() {
        return new EditText[]{txtNombre, txtApaterno, txtAmaterno, txtNumeroControl};
    }

    private Spinner[] regresarSpinner(){
        Spinner[] all = new Spinner[2];
        all[0]=spinnerGenero;
        all[1]=spinnerCarrera;
        return all;
    }

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

    @OnClick(R.id.alBtnRegistrar)
    public void click() {
        if (validarTxt(regresarArregloEditText())) {
            alumno = new Alumno();
            alumno.setNombre(txtNombre.getText().toString());
            alumno.setSexo(spinnerGenero.getSelectedItem().toString());
            alumno.setaMaterno(txtAmaterno.getText().toString());
            alumno.setaPaterno(txtApaterno.getText().toString());
            alumno.setNumeroDeControl(txtNumeroControl.getText().toString());
            alumno.setCarrera(spinnerCarrera.getSelectedItemPosition() + 1);
            AlumnoC alumnoC = new AlumnoC(alumno, getApplicationContext());
            alumnoC.registrar();
            limpiarTxt(regresarArregloEditText());
        }
    }

    @OnClick(R.id.alBtnEliminar)
    public void clickEliminar() {
        if (txtId.getText().toString().trim().equals("")) {
            txtId.setError("Debes de ingresar un id a eliminar");
            return;
        }
        alumno = new Alumno();
        alumno.setId_alumno(Integer.parseInt(txtId.getText().toString()));
        AlumnoC alumnoC = new AlumnoC(alumno, getApplicationContext());
        alumnoC.eliminarAlumno();
        txtId.setText(null);
    }

    @OnClick(R.id.alBtnBuscar)
    public void clickBuscar() {
        if (txtId.getText().toString().trim().equals("")) {
            txtId.setError("Debes de ingresar un id a buscar");
            return;
        }
        alumno = new Alumno();
        AlumnoC alumnoC = new AlumnoC(alumno, getApplicationContext());
        alumnoC.searchStudent(txtId.getText().toString(),regresarArregloEditText(),regresarSpinner());
    }

    @OnClick(R.id.alBtnActualizar)
    public void clickActualizar() {
        alumno = new Alumno();
        alumno.setNombre(txtNombre.getText().toString());
        alumno.setSexo(spinnerGenero.getSelectedItem().toString());
        alumno.setaMaterno(txtAmaterno.getText().toString());
        alumno.setaPaterno(txtApaterno.getText().toString());
        alumno.setNumeroDeControl(txtNumeroControl.getText().toString());
        alumno.setCarrera(spinnerCarrera.getSelectedItemPosition() + 1);
        alumno.setId_alumno(Integer.parseInt(txtId.getText().toString()));
        AlumnoC alumnoC = new AlumnoC(alumno, getApplicationContext());
        alumnoC.actualizar();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        ButterKnife.bind(this);
    }
}
