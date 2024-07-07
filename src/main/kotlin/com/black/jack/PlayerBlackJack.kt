package com.black.jack

import kotlin.random.Random
import kotlin.random.nextInt

abstract class PlayerBlackJack(initialName: String) {
    private val name: String = initialName
        get() = field.replaceFirstChar { it.uppercase() }.changeColor(color = Color.YELLOW)
    protected abstract val pronoun: String
    abstract var costOfHand: Int
    protected abstract val cardsInHand: MutableList<String>
    private var numberOfAces: Int = 0

    private val cards = Deck()

    fun information(): String {
        return """
    |--$name:
    |      --the value of $pronoun hand is ${costOfHand.changeColor(color = Color.GREEN)},
    |      --$pronoun cards are "${cardsInHand.joinToString("| ")}"
        """.trimMargin()
    }

    protected val finish: String by lazy {
        """
            |$name $pronoun finished taking the cards,
            |the value of $pronoun hand is ${costOfHand.changeColor(color = Color.GREEN)},
            |$pronoun cards are "${cardsInHand.joinToString("| ")}"
        """.trimMargin()
    }

    fun takeCard() {
        val tookCard = cards.getCard()

        val typeOfCard = tookCard.first
        val nameOfType = typeOfCard.name.lowercase().replaceFirstChar { it.uppercase() }

        val suitOfCard = tookCard.second
        val nameOfSuit = suitOfCard.name.lowercase().replaceFirstChar { it.uppercase() }

        costOfHand += typeOfCard.cost

        cardsInHand += "${typeOfCard.symbol}${suitOfCard.suit} ($nameOfType of $nameOfSuit)".changeColor(
            color = if (suitOfCard == Suit.HEARTS || suitOfCard == Suit.DIAMONDS) {
                Color.RED
            } else {
                Color.BLUE
            }
        )

        println("$name is taking a card...")
        Thread.sleep(500)

        println("""it's "${cardsInHand.last()}" its value is ${typeOfCard.cost.changeColor(color = Color.GREEN)}""")
        if (typeOfCard == Rank.ACE) {
            numberOfAces++
        }

        recalculateOfAces()
    }

    private fun recalculateOfAces() {
        while (costOfHand > 21 && numberOfAces > 0) {
            costOfHand -= 10
            numberOfAces--
        }
    }

    protected open fun artificialIntelligence(): String {
        println("$name starts taking cards")


        while (true) {
            when (costOfHand) {
                in 0..11 -> takeCard()

                in 12..15 -> {
                    when (Random.nextInt(1..2)) {
                        1 -> takeCard()
                        else -> return finish
                    }
                }

                in 16..17 -> {
                    when (Random.nextInt(1..10)) {
                        1 -> takeCard()
                        else -> return finish
                    }
                }

                in 18..19 -> {
                    when (Random.nextInt(1..100)) {
                        in 1..4 -> takeCard()
                        else -> return finish
                    }
                }

                20 -> {
                    when (Random.nextInt(1..100)) {
                        in 1..2 -> takeCard()
                        else -> return finish
                    }
                }

                21 -> return "$finish. \nCareful, the dealer got twenty-one points"

                else -> return "$finish.\nTake as many cards as you want, the dealer has too much"
            }
        }
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