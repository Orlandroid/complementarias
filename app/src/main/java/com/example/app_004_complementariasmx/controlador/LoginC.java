package com.example.app_004_complementariasmx.controlador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_004_complementariasmx.MenuPrincipal;
import com.example.app_004_complementariasmx.modelo.Alumno;
import com.example.app_004_complementariasmx.modelo.Usuario;

import java.util.HashMap;
import java.util.Map;


public class LoginC {


    private RequestQueue requestQueue;
    private Context context;
    private Usuario usuario;
    private String URL = "http://192.168.0.157/AndroidCrud/validar.php";

    public LoginC(Context context, Usuario user) {
        this.context = context;
        this.usuario = user;
    }



    public void login() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("R",response.toString());
                if (response.trim().equals("find")) {
                    Toast.makeText(context, "Iniciando session", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, MenuPrincipal.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                } else
                    Toast.makeText(context, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error conexion de internet", Toast.LENGTH_SHORT).show();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("usuario", usuario.getUsuario());
                params.put("clave", usuario.getContra());
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(stringRequest);
    }


}
