package com.example.jokebpo

class Jogada {

    var jogador : Int = 0
    var maquina : Int = 0
    var resultado : String = ""

    // INFORMAÇÃO COMPARTILHADA PELA CLASSE

    companion object{
        private val historico = mutableListOf<Jogada>()

    }


    //quando eu chamar a classe jogada
    //devo passar os meus valores

    constructor( minhaJogada : Int, jogadaMaquina : Int, resultado : String ){

        jogador = minhaJogada
        maquina = jogadaMaquina

        //referencia da caracteristica da classe
        this.resultado = resultado

    }

    constructor(){

    }


    // FUNÇAO PARA ADICIONAR AS JOGADAS NA LISTA

    fun AdicionarJogada(novaJogada : Jogada ){
        historico.add( novaJogada )

    }

    //DEVOLVENDO TODAS AS LISTAS

    fun ListarJogadas() : List<Jogada>{

        return historico.toList()

    }

    override fun toString(): String {

       var tradutor = if(jogador == 0) {
            "Papel"
       }else if(jogador == 1) {
            "Pedra"
       }else{
            "Tesoura"
       }

        return "A minha jogada ${tradutor}, a jogada da maquina ${maquina}, e o resultado ${resultado}"
    }


}