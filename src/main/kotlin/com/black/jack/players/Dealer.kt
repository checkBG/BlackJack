package com.black.jack.players

class Dealer(nameDealer: String = "The dealer") : PlayerBlackJack(nameDealer) {
    override val pronoun: String = "his"
    override var costOfHand: Int = 0
    override val cardsInHand: MutableList<String> = mutableListOf()

    init {
        println(artificialIntelligence())
    }
}