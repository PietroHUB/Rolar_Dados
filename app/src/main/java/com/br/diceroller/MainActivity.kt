package com.br.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    /*
    * A lateinitpalavra-chave promete ao compilador Kotlin que a variável
    * será inicializada antes que o código chame qualquer operação nela*/
    lateinit var diceImage : ImageView
    lateinit var diceImage1 : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pegando a referencia do que está no xml da tela
        //será uma constante pois não será alterada
        val btnRollarDado: Button = findViewById(R.id.Btn_rollarDado)

        diceImage = findViewById(R.id.Img_result)
        diceImage1 = findViewById(R.id.Img_result1)

        //evento de click no button
        btnRollarDado.setOnClickListener{
            rolarDado()
        }
    }

    private fun rolarDado(){
        println("==========Evento de click no botão rolar dados!")
       Toast.makeText(this, "Dado rolado!" , Toast.LENGTH_SHORT).show()
        diceImage.setImageResource(getRandomDiceImage())
        diceImage1.setImageResource(getRandomDiceImage())
    }
    private fun getRandomDiceImage() : Int {
        val randomInteiro = (1..6).random()
        println("========== ramdomInteiro: ${randomInteiro}")
        val drawableResource = when(randomInteiro){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        println("========== drawableResource: ${drawableResource}")
        return drawableResource
    }
}
