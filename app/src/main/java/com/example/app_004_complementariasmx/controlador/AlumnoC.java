package com.example.app_004_complementariasmx.controlador;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_004_complementariasmx.MySingleton;
import com.example.app_004_complementariasmx.modelo.Alumno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AlumnoC {

    private Alumno alumno;
    private final String URL_ROOT = "http://192.168.0.157/AndroidCrud/alumno.php?accion=";
    private final String REGISTRAR = URL_ROOT + "registrar";
    private final String ACTUALIZAR = URL_ROOT + "actualizar";
    private final String ELIMINAR = "http://192.168.0.157/AndroidCrud/delete.php";
    private String BUSCAR = "http://192.168.0.157/AndroidCrud/buscar_alumno.php";
    private Context context;
    private RequestQueue requestQueue;
    private JSONObject obj;

    public AlumnoC(Alumno alumno, Context context) {
        this.alumno = alumno;
        this.context = context;
    }

    public void searchStudent(String id, EditText[] datos, Spinner[] datosSpiner) {
        BUSCAR += "?id=" + id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, BUSCAR, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String name = response.getString("nombre");
                            String sexo = response.getString("sexo");
                            String materno = response.getString("apellido_materno");
                            String paterno = response.getString("apellido_paterno");
                            String numero = response.getString("numero_control");
                            int carrera=response.getInt("id_carrera");
                            datos[0].setText(name);
                            datos[1].setText(paterno);
                            datos[2].setText(materno);
                            datos[3].setText(numero);
                            datosSpiner[1].setSelection(carrera-1);
                           if(sexo.equals("Hombre"))
                               datosSpiner[0].setSelection(0);
                           else
                               datosSpiner[0].setSelection(1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Log.w("ERROR", Objects.requireNonNull(error.getMessage()));
                    }
                });

        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }


    public void actualizar() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ACTUALIZAR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Se registro actualizo al alumno", Toast.LENGTH_SHORT).show();
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
                params.put("id", String.valueOf(alumno.getId_alumno()));
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void eliminarAlumno() {
        StringRequest postRequest = new StringRequest(Request.Method.POST, ELIMINAR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, "Se elimino al alumno correctamente", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(alumno.getId_alumno()));
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(postRequest);
    }

    public void registrar() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTRAR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Se registro correctamente al alumno", Toast.LENGTH_SHORT).show();
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
                params.put("materno", alumno.getaMaterno());
                params.put("paterno", alumno.getaPaterno());
                params.put("numero", alumno.getNumeroDeControl());
                params.put("carrera", String.valueOf(alumno.getCarrera()));
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(stringRequest);
    }


}
