package com.black.jack.players

import kotlin.random.Random
import kotlin.random.nextInt

class Dealer(nameDealer: String = "The dealer") : PlayerBlackJack(nameDealer) {
    override val pronoun: String = "his"

    init {
        println(artificialIntelligence())
    }

    private fun artificialIntelligence(): String {
        println("$name starts taking cards")

        while (true) {
            when (hand.costOfHand) {
                in 0..11 -> takeCard()

                in 12..15 -> {
                    when (Random.nextInt(1..2)) {
                        1 -> takeCard()
                        else -> return information()
                    }
                }

                in 16..17 -> {
                    when (Random.nextInt(1..10)) {
                        1 -> takeCard()
                        else -> return information()
                    }
                }

                18 -> {
                    when (Random.nextInt(1..100)) {
                        in 1..4 -> takeCard()
                        else -> return information()
                    }
                }

                in 19..21 -> return "${information()}. \nCareful, the dealer got twenty-one points"

                else -> return "${information()}.\nTake as many cards as you want, the dealer has too much"
            }
        }
    }
}