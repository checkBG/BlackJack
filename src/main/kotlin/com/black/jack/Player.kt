package com.black.jack

class Player(name: String) : PlayerBlackJack(name) {
    override val pronoun: String = "your"
    override var costOfHand: Int = 0
    override val cardsInHand: MutableList<String> = mutableListOf()
    override var numberOfAces: Int = 0
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
        print("Your cards are \"$redColor${cardsInHand.joinToString(", ")}$resetColor\" its cost is $costOfHand. Another card? Yes/No: ")
    }

    fun oneMoreCard() {
        takeCard()
        question()
    }
}