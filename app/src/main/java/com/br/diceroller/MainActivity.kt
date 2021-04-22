package com.br.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pegando a referencia do que está no xml da tela

        //será uma constante pois não será alterada
        val rolarButton: Button = findViewById(R.id.Btn_rollarDado)
        val txtResult: TextView = findViewById(R.id.Txt_result)

        //evento de click no button
        rolarButton.setOnClickListener{
            txtResult.text = rolarDado().toString()
        }

    }

    private fun rolarDado(): Int{
        println("==========Evento de click no botão rolar dados!")
        val randomInteiro = (1..6).random()
        println("========== ramdomInteiro: ${randomInteiro}")
        Toast.makeText(this, "Dado rolado!" , Toast.LENGTH_SHORT).show()
        return randomInteiro
    }
}
