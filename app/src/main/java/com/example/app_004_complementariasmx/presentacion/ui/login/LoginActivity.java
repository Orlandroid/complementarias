package com.example.app_004_complementariasmx.presentacion.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.app_004_complementariasmx.databinding.ActivityMainBinding;
import com.example.app_004_complementariasmx.domain.modelo.remote.LoginRequest;
import com.example.app_004_complementariasmx.presentacion.ui.alumnos.Alumnos;
import com.example.app_004_complementariasmx.presentacion.ui.menu.MenuPrincipal;
import com.example.app_004_complementariasmx.presentacion.util.UtilKt;

import okhttp3.internal.Util;


public class LoginActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private MenuViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MenuViewModel.class);
        setUpUi();
        observeViewModel();
    }

    private void setUpUi() {
        binding.btnIniciarSession.setOnClickListener(v -> {
            if (UtilKt.isNetworkConnected(getApplicationContext())) {
                String usuario = binding.user.getText().toString();
                String password = binding.user.getText().toString();
                LoginRequest loginRequest = new LoginRequest(usuario, password);
                viewModel.login(loginRequest);
                return;
            }
            Toast.makeText(this, "Error conexion de internet", Toast.LENGTH_SHORT).show();
        });
    }

    private void observeViewModel() {
        viewModel.getLogin().observe(this, response -> {
            if (response) {
                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuario y contrasena inconrrecta", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
