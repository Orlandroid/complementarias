package com.example.app_004_complementariasmx.controlador;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_004_complementariasmx.modelo.Alumno;

import java.util.HashMap;
import java.util.Map;

public class AlumnoC {

    private Alumno alumno;
    private final String URL_ROOT = "http://192.168.2.106/complementariasmx/android/CrudAlumno.php?accion=";
    private final String REGISTRAR = URL_ROOT + "registrar";
    private final String ACTUALIZAR = URL_ROOT + "actualizar";
    private final String ELIMINAR = URL_ROOT + "eliminar";
    private Context context;
    private RequestQueue requestQueue;


    public AlumnoC(Alumno alumno, Context context) {
        this.alumno = alumno;
        this.context = context;
    }


    private void eliminarAlumno() {
        StringRequest postRequest = new StringRequest(Request.Method.POST, ELIMINAR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, "Se eliminaron correctamente los registros", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("codigo", alumno.getNumeroDeControl().toString());
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(postRequest);
    }

    public void registrarAlumno() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTRAR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Se agrego al alumno correctamente", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", alumno.getNombre());
                params.put("sexo", alumno.getSexo());
                params.put("apellido_materno", alumno.getaMaterno());
                params.put("apellido_paterno", alumno.getaPaterno());
                params.put("numero_control", alumno.getNumeroDeControl());
                params.put("id_carrera", String.valueOf(alumno.getCarrera()));
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(stringRequest);
    }


}
