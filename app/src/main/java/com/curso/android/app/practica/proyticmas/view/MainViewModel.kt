package com.curso.android.app.practica.proyticmas.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.curso.android.app.practica.proyticmas.model.Words

class MainViewModel: ViewModel() {

    // Solo queremos que se pueda leer palabra
    val palabra: LiveData<Words> get() = _palabras
    // no nos interesa que se modifique por fuera del ViewModel
    private var _palabras = MutableLiveData<Words>(Words("","",""))

    fun compararPalabras(pal11: String,pal22: String, esta2:String) {

        val pal3 = pal11
        val pal4 = pal22
        var estado = "sin evaluar"

        if (pal3 == pal4)
        {
            println("Equal")
            println("Las palabras '$pal11' y '$pal22' son iguales")
            estado = "SON IGUALES"
        }
        else
        {
            println("Not Equal")
            println("'$pal11' es distinta de '$pal22'")
            println("Las palabras '$pal11' y '$pal22' son distintas")
            estado = "SON DISTINTAS"
        }

        updatePalabras(pal11, pal22, estado)
    }

    private fun updatePalabras(pal1: String, pal2: String, est2:String ){
        _palabras.value = Words(pal1,pal2, est2)
    }
}