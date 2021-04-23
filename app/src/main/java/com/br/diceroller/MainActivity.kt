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
        val btnRollarDado: Button = findViewById(R.id.Btn_rollarDado)
        val txtResult: TextView = findViewById(R.id.Txt_result)
        val btnContagem: Button = findViewById(R.id.Btn_contagem)
        val btnReiniciar: Button = findViewById(R.id.Btn_reiniciar)

        //evento de click no button
        btnRollarDado.setOnClickListener{
            txtResult.text = rolarDado().toString()
        }
        btnContagem.setOnClickListener{contagem()}
        btnReiniciar.setOnClickListener{reiniciar()}
    }

    private fun rolarDado(): Int{
        println("==========Evento de click no botão rolar dados!")
        val randomInteiro = (1..6).random()
        println("========== ramdomInteiro: ${randomInteiro}")
        Toast.makeText(this, "Dado rolado!" , Toast.LENGTH_SHORT).show()
        return randomInteiro
    }

    private fun contagem(){
        println("========== contagem: ")
        val txtResult: TextView = findViewById(R.id.Txt_result)

        if(txtResult.text == "Olá mundo Kotlin"){
            txtResult.text = "1"
        }else{
            var txtResultInt = txtResult.text.toString().toInt()
            if(txtResultInt  < 6) {
                txtResultInt ++
                txtResult.text = txtResultInt.toString()
            }
        }
    }
    private fun reiniciar(){
        println("========== reiniciar: ")
        val txtResult: TextView = findViewById(R.id.Txt_result)
        txtResult.text = "0"
        println("========== txtResult: ${txtResult.text}")
    }
}
