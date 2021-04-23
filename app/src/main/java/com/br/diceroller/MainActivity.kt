package com.br.diceroller

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
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
    lateinit var btnLimpar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ocultando barras de status do android
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()



        //pegando a referencia do que está no xml da tela
        //será uma constante pois não será alterada
        val btnRollarDado: Button = findViewById(R.id.Btn_rollarDado)

        diceImage = findViewById(R.id.Img_result)
        diceImage1 = findViewById(R.id.Img_result1)

        btnLimpar = findViewById(R.id.Btn_Limpar)

        //evento de click no button
        btnRollarDado.setOnClickListener{rolarDado()}
        btnLimpar.setOnClickListener{
            limparDado()
            Toast.makeText(this, "Dados Limpos!" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun rolarDado(){
        println("==========Evento de click no botão rolar dados!")
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

    private fun limparDado(){
        println("========== limparDado: R.drawable.empty_dice")
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage1.setImageResource(R.drawable.empty_dice)
    }
}
