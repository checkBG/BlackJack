package com.black.jack.players

class Player(name: String) : PlayerBlackJack(name) {
    override val pronoun: String = "your"
    override var costOfHand: Int = 0
    override val cardsInHand: MutableList<String> = mutableListOf()
    override fun artificialIntelligence(): String {
        repeat(2) {
            takeCard()
        }
        return finish
    }

    init {
        println(artificialIntelligence())
    }

    fun question() {
        println(information())
        println("Another card? Yes/No: ")
    }
}