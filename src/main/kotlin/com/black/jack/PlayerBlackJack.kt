package com.black.jack

import kotlin.random.Random
import kotlin.random.nextInt

abstract class PlayerBlackJack(initialName: String) {
    private val name: String = initialName
        get() = field.replaceFirstChar { it.uppercase() }
    protected abstract val pronoun: String
    abstract var costOfHand: Int
    protected abstract val cardsInHand: MutableList<String>
    protected abstract var numberOfAces: Int

    private val cards = Cards()

    fun information(): String {
        return """
    |--$name:
    |      --the value of $pronoun hand is ${Color.GREEN.color}$costOfHand${Color.RESET.color},
    |      --$pronoun cards are "${cardsInHand.joinToString("| ")}"
        """.trimMargin()
    }

    protected val finish: String by lazy {
        """
            |$name $pronoun finished taking the cards,
            |the value of $pronoun hand is ${Color.GREEN.color}$costOfHand${Color.RESET.color},
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
        cardsInHand += "${
            if (suitOfCard == Suit.HEARTS || suitOfCard == Suit.DIAMONDS) {
                Color.RED.color
            } else {
                Color.BLUE.color
            }
        }$nameOfType ${suitOfCard.suit}($nameOfSuit)${Color.RESET.color}"

        println("$name is taking a card...")
        Thread.sleep(500)
//        println("""it's "${Color.RED.color}$nameOfType of $nameOfSuit${Color.RESET.color}" its value is ${Color.GREEN.color}${typeOfCard.cost}${Color.RESET.color}""")
        println("""it's "${cardsInHand.last()}" its value is ${Color.GREEN.color}${typeOfCard.cost}${Color.RESET.color}""")
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