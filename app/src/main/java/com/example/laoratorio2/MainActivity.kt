package com.example.laoratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var etn_Nombre : EditText
    private lateinit var etn_Edad : EditText
    private lateinit var etn_Departamento : EditText
    private lateinit var lv_Persona: ListView
    private lateinit var  tv_seleccionado : TextView


    var names = ArrayList<String>()
    var ages = ArrayList<String>()
    var departments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etn_Nombre = findViewById(R.id.etn_Nombre)
        etn_Edad = findViewById(R.id.etn_Edad)
        etn_Departamento = findViewById(R.id.etn_Departamento)
        lv_Persona = findViewById(R.id.lv_Persona)
        tv_seleccionado = findViewById(R.id.tv_seleccionado)

        etn_Nombre.addTextChangedListener {
            if (etn_Nombre.text.length == 0) etn_Nombre.setError("Nombre vacio")
        }

        etn_Edad.addTextChangedListener {
            if (etn_Edad.text.length == 0) etn_Edad.setError("Edad vacio")
        }

        etn_Departamento.addTextChangedListener {
            if (etn_Departamento.text.length == 0) etn_Departamento.setError("Departamento vacio")
        }

        fun isValidate(): Boolean {

        }

        fun addItem(view: View) {
            var nombre = etn_Nombre.text.toString()
            var edad = etn_Edad.text.toString()
            var departamento = etn_Departamento.text.toString()

            if (isValidate()) {
                nombre.add(nombre)
                edad.add(edad)
                departamento.add(departamento)
                addListView()
                clear()
            } else {
                Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show()
            }
        }

        private fun isValidate(): Boolean {
            var empty = false

            if (etn_Nombre.text.isNotEmpty() && etn_Edad.text.isNotEmpty() && etn_Departamento.text.isNotEmpty()) {
                empty = true
            } else {
                Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show()
            }

            return empty
        }

        private fun addListView() {
            val adapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, R.layout.list_persona, names)
            lv_Persona.apply {
                this?.adapter = adapter

                this?.onItemClickListener = object : AdapterView.OnItemClickListener {
                    override fun onItemClick(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        tv_seleccionado.text =
                            "Informacion: ${names[position]}, ${ages[position]} años, ${departments[position]}"
                    }
                }
            }
        }

        private fun clear() {
            etn_Nombre.text.clear()
            etn_Edad.text.clear()
            etn_Departamento.text.clear()
        }
    }




}