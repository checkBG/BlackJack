package com.blackjack.players

import com.blackjack.Game
import com.blackjack.Rank
import com.blackjack.Suit
import com.blackjack.model.Hand
import com.blackjack.model.ReceivedCard
import com.blackjack.utils.Color
import com.blackjack.utils.changeColor

abstract class PlayerBlackjack(initialName: String) {
    val name: String = initialName
        get() = field.replaceFirstChar { it.uppercase() }.changeColor(color = Color.YELLOW)

    val hand = Hand()

    abstract val pronoun: String

    fun takeCard() {
        val tookCard = Game.deck.getCard()

        val receivedCard = ReceivedCard(
            rankOfCard = tookCard.first,
            suitOfCard = tookCard.second
        )

        calculateHandCost(receivedCard = receivedCard)

        println("$name is taking a card...")
        Thread.sleep(500) // симуляция взятия карты

        println("""it's "${hand.cardsInHand.last()}" its value is ${receivedCard.rankOfCard.cost.changeColor(color = Color.GREEN)}""")

    }

    private fun calculateHandCost(receivedCard: ReceivedCard) {
        hand.costOfHand += receivedCard.rankOfCard.cost

        hand.cardsInHand += "${receivedCard.rankOfCard.symbol}${receivedCard.suitOfCard.suit} (${receivedCard.nameOfRank} of ${receivedCard.nameOfSuit})".changeColor(
            color = if (receivedCard.suitOfCard == Suit.HEARTS || receivedCard.suitOfCard == Suit.DIAMONDS) {
                Color.RED
            } else {
                Color.BLUE
            }
        )

        if (receivedCard.rankOfCard == Rank.ACE) {
            hand.numberOfAces++
        }

        while (hand.costOfHand > 21 && hand.numberOfAces > 0) {
            hand.costOfHand -= 10
            hand.numberOfAces--
        }
    }

    fun information(): String {
        return """
    |--$name:
    |      --the value of $pronoun hand is ${hand.costOfHand.changeColor(color = Color.GREEN)},
    |      --$pronoun cards are "${hand.cardsInHand.joinToString("| ")}"
        """.trimMargin()
    }

    protected fun defaultDistribution(): String {
        repeat(2) {
            takeCard()
        }
        return information()
    }

    companion object {
        fun enterName(): String {
            print("Enter the player's name: ")
            val input = readlnOrNull() ?: "Unknown"
            require(input.isNotBlank()) { "The name cannot be empty" }
            return input
        }
    }
}