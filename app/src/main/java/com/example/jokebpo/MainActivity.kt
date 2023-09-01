package com.example.jokebpo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //INDENTIFICANDO NOSSOS RECURSOS

     lateinit var btn_historico : Button
     lateinit var btn_pedra : ImageButton
     lateinit var btn_papel : ImageButton
     lateinit var btn_tesoura : ImageButton
     lateinit var imgMaquina : ImageView
     lateinit var resultado : TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recebendo os recursos

        btn_papel = findViewById(R.id.btn_papel)
        btn_pedra = findViewById(R.id.btn_pedra)
        btn_tesoura = findViewById(R.id.btn_tesoura)
        btn_historico = findViewById(R.id.btn_historico)

        resultado = findViewById(R.id.resultado)
        imgMaquina = findViewById(R.id.random_img)


        btn_papel.setOnClickListener() {
            resultado.text = Jogar(0)
        }

        btn_pedra.setOnClickListener() {
            resultado.text = Jogar(1)
        }

        btn_tesoura.setOnClickListener(){
            resultado.text = Jogar( 2 )
        }

        // CHAMADA DA NOVA ACTIVITY

        btn_historico.setOnClickListener(){
            val intent = Intent( this, HistoricoActivity::class.java )
            startActivity( intent )

        }

    }

    // nossa jogada

    fun Jogar( jogada : Int ) : String{

        // chamando a jogada da maquina

        var resultado : String = ""
        val resultadoMaquina = resultadoMaquina()

        if( jogada == resultadoMaquina) {

            resultado = "Empatou"

        }else{


            if( jogada == 0 && resultadoMaquina == 1 ||
                jogada == 1 && resultadoMaquina == 2 ||
                jogada == 2 && resultadoMaquina == 0){

                resultado = "Ganhou"

            }else{

                resultado = "Perdeu"
            }
        }

        // ADICIONAR NO HISTORICO DE JOGADAS
        var novaJogada = Jogada( jogada, resultadoMaquina, resultado  )
        novaJogada.AdicionarJogada( novaJogada )


        return  resultado

    }

    //FUNÇÃO DE JOGADA DA MAQUINA

    fun resultadoMaquina() : Int{


        // imagem de visualização da maquina

        imgMaquina = findViewById(R.id.random_img)

        var numeroRandom = Random.nextInt( 3)


        // 0 - papel / 1 pedra / 2 tesoura

        when( numeroRandom ){

            0 -> imgMaquina.setImageDrawable( getDrawable(R.drawable.papel))
            1 -> imgMaquina.setImageDrawable( getDrawable(R.drawable.pedra))
            2 -> imgMaquina.setImageDrawable( getDrawable(R.drawable.tesoura))

        }

        return numeroRandom

    }

}