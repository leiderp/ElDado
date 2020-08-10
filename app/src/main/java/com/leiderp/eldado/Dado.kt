package com.leiderp.eldado

class Dado (val numLados : Int){
    fun lanzar() : Int{
        return (1..numLados).random()
    }
}