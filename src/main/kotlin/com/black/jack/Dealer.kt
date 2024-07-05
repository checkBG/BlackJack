package com.black.jack

class Dealer(nameDealer: String = "The dealer") : PlayerBlackJack(nameDealer) {
    override val pronoun: String = "his"
    override var costOfHand: Int = 0
    override val cardsInHand: MutableList<String> = mutableListOf()
    override var numberOfAces: Int = 0

    init {
        println(artificialIntelligence())
    }
}