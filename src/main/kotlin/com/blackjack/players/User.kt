package com.blackjack.players

class User(name: String) : Player(name) {
    override val pronoun: String = "your"

    init {
        defaultDistribution()
    }
}