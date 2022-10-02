package com.example.app_004_complementariasmx.presentacion.ui.alumnos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_004_complementariasmx.R
import com.example.app_004_complementariasmx.domain.modelo.Alumno
import java.util.*

class AdaptadorAlumno(val alumnos: ArrayList<Alumno>) :
    RecyclerView.Adapter<AdaptadorAlumno.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.txtNombre)
        val sexo: TextView = itemView.findViewById(R.id.txtSexo)
        val numero: TextView = itemView.findViewById(R.id.txtNumeroDeControl)
        val carrera: TextView = itemView.findViewById(R.id.txtCarrera)
        val acciones: Button = itemView.findViewById(R.id.txtBtnAcciones)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.elemento_alumno, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alumno = alumnos[position]
        holder.nombre.text = alumno.nombre
        holder.sexo.text = alumno.sexo
        holder.numero.text = alumno.numeroDeControl
        holder.carrera.text = alumno.carrera.toString()
    }

    override fun getItemCount(): Int = alumnos.size


}