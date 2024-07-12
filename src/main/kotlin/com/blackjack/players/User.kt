package com.blackjack.players

class User(name: String) : PlayerBlackjack(name) {
    override val pronoun: String = "your"

    init {
        println(defaultDistribution())
    }
}