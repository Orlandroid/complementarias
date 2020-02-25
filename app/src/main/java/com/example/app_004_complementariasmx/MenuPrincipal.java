package com.example.app_004_complementariasmx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuPrincipal extends AppCompatActivity {

    @BindView(R.id.cardview)
    CardView cardViewEscuela;

    @OnClick(R.id.cardview)
    public void clik() {
        Intent intent = new Intent(this, AlumnosActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        ButterKnife.bind(this);
    }
}
