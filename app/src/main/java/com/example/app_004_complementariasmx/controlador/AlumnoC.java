package com.example.app_004_complementariasmx.controlador;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_004_complementariasmx.MySingleton;
import com.example.app_004_complementariasmx.modelo.Alumno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AlumnoC {

    private Alumno alumno;
    private final String URL_ROOT = "http://192.168.2.106/complementariasmx/android/CrudAlumno.php?accion=";
    private final String REGISTRAR = URL_ROOT + "registrar";
    private final String ACTUALIZAR = URL_ROOT + "actualizar";
    private final String ELIMINAR = URL_ROOT + "eliminar";
    private String BUSCAR = URL_ROOT + "buscar";
    private Context context;
    private RequestQueue requestQueue;
    private JSONObject obj;

    public AlumnoC(Alumno alumno, Context context) {
        this.alumno = alumno;
        this.context = context;
    }

    public void setValuesForAlumno() {
        try {
            alumno.setNombre(obj.getString("nombre"));
            alumno.setSexo(obj.getString("sexo"));
            alumno.setaMaterno(obj.getString("apellido_materno"));
            alumno.setaPaterno(obj.getString("apellido_paterno"));
            alumno.setNumeroDeControl(obj.getString("numero_control"));
            alumno.setId_alumno(Integer.parseInt(obj.getString("id_carrera")));
            Toast.makeText(context, "Segundo metodo", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(String id) {
        BUSCAR += "&codigo=" + id;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(BUSCAR, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        obj = response.getJSONObject(i);
                        Toast.makeText(context, "primer metodo", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        }
        );
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
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
