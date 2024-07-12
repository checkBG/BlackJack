package com.black.jack.players

class User(name: String) : PlayerBlackJack(name) {
    override val pronoun: String = "your"

    init {
        println(defaultDistribution())
    }

    fun question() {
//        println(information())
        println("Another card? Yes/No: ")
    }
}