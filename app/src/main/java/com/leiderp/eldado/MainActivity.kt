package com.leiderp.eldado

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    var result1  = 0
    var result2 = 0
    var turno = "Jugador1"
    fun init(){
        result1 = 0
        result2 = 0
        turno = "Jugador1"
        val ivDado: ImageView = findViewById(R.id.imageView)
        val ivDado2: ImageView = findViewById(R.id.imageView2)
        val ivWin1 : ImageView = findViewById(R.id.imageView4)
        val ivWin2 : ImageView = findViewById(R.id.imageView5)
        val result_1: TextView = findViewById(R.id.textView5)
        val result_2: TextView = findViewById(R.id.textView4)
        val buton: Button = findViewById(R.id.button)
        val buton2: Button = findViewById(R.id.button2)
        ivDado.setImageResource(R.drawable.dice_1)
        ivDado2.setImageResource(R.drawable.dice_1)
        ivWin1.setImageResource(R.drawable.fondo)
        ivWin2.setImageResource(R.drawable.fondo)
        result_1.setText("0")
        result_2.setText("0")
        buton.isEnabled = false
        buton2.isEnabled = true
        Toast.makeText(this,"El Turno es Para: $turno",Toast.LENGTH_SHORT).show()
    }
    fun reload(view: View){
        init()
    }

    fun onClickLanzar(view: View) {
        val dado = Dado(6)
       // Log.d("Aplicacion de dados","OnClick")
        val valorDado = dado.lanzar().toInt()
        val valorDado2 = dado.lanzar().toInt()
        val ivDado: ImageView = findViewById(R.id.imageView)
        val ivDado2: ImageView = findViewById(R.id.imageView2)
        val buton: Button = findViewById(R.id.button)
        val buton2: Button = findViewById(R.id.button2)
        val ivWin1 : ImageView = findViewById(R.id.imageView4)
        val ivWin2 : ImageView = findViewById(R.id.imageView5)
        val result_1: TextView = findViewById(R.id.textView5)
        val result_2: TextView = findViewById(R.id.textView4)
        asignarValor(valorDado,ivDado)
        asignarValor(valorDado2,ivDado2)
        Toast.makeText(this,"$turno ha obtenido un: $valorDado y $valorDado2",Toast.LENGTH_SHORT).show()
        if (turno =="Jugador1"){
            result1 = valorDado + valorDado2
            result_1.setText("$result1")
            turno = "Jugador2"
            Toast.makeText(this,"El turno es para: $turno",Toast.LENGTH_SHORT).show()
            buton.isEnabled = true
            buton2.isEnabled = false

        }
        else{
            result2 = valorDado + valorDado2
            result_2.text = "$result2"
            buton.isEnabled = false

        }

        if (result1 != 0 && result2 != 0){
            if (result1 > result2){
                Toast.makeText(this,"Jugador1 ha Ganado",Toast.LENGTH_SHORT).show()
                ivWin1.setImageResource(R.drawable.win)
                ivWin2.setImageResource(R.drawable.perdedor)
            }else{
                if (result2 > result1) {
                    Toast.makeText(this, "Jugador2 ha Ganado", Toast.LENGTH_SHORT).show()
                    ivWin2.setImageResource(R.drawable.win)
                    ivWin1.setImageResource(R.drawable.perdedor)
                }else{
                    Toast.makeText(this, "Partida Empatada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun asignarValor(valorDado:Int,ivDado:ImageView){
        when(valorDado){
            1 -> ivDado.setImageResource(R.drawable.dice_1)
            2 -> ivDado.setImageResource(R.drawable.dice_2)
            3 -> ivDado.setImageResource(R.drawable.dice_3)
            4 -> ivDado.setImageResource(R.drawable.dice_4)
            5 -> ivDado.setImageResource(R.drawable.dice_5)
            6 -> ivDado.setImageResource(R.drawable.dice_6)
        }
    }


}