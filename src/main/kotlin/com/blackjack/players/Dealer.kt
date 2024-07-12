package com.blackjack.players

import kotlin.random.Random
import kotlin.random.nextInt

class Dealer(nameDealer: String = "The dealer") : Player(nameDealer) {
    override val pronoun: String = "his"

    fun artificialIntelligence() {
        println("$name starts taking cards")
        defaultDistribution()

        while (true) {

            when (hand.costOfHand) {
                in 0..11 -> takeCard()

                in 12..15 -> {
                    when (Random.nextInt(1..2)) {
                        1 -> takeCard()
                        else -> return
                    }
                }

                in 16..17 -> {
                    when (Random.nextInt(1..10)) {
                        1 -> takeCard()
                        else -> return
                    }
                }

                18 -> {
                    when (Random.nextInt(1..100)) {
                        in 1..4 -> takeCard()
                        else -> return
                    }
                }

                in 19..21 -> return

                else -> return
            }
        }
    }
}