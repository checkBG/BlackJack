package com.blackjack.players

class Dealer(nameDealer: String = "The dealer") : Player(nameDealer) {
    override val pronoun: String = "his"

    init {
        defaultDistribution()
        println(information())
    }

    override fun defaultDistribution() {
        takeCard()
    }

    fun setOfCardsByDealer() {
        println("Myself...")
        println("$name starts taking cards")

        while (hand.costOfHand < 17) {
            takeCard()
        }
    }
}