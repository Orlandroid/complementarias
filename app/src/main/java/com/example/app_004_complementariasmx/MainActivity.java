package com.example.app_004_complementariasmx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_004_complementariasmx.controlador.LoginC;
import com.example.app_004_complementariasmx.modelo.Usuario;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtUsuario)
    EditText txtUsuario;
    @BindView(R.id.txtContra)
    EditText txtContra;
    @BindView(R.id.btnIniciarSession)
    Button btnIniciarSession;

    @OnClick(R.id.btnIniciarSession)
    public void click() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(txtUsuario.getText().toString().trim());
        usuario.setContra(txtContra.getText().toString().trim());
        LoginC loginC = new LoginC(this, usuario);
        loginC.login();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
