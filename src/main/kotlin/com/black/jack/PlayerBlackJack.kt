package com.black.jack

import kotlin.random.Random
import kotlin.random.nextInt

abstract class PlayerBlackJack(private val name: String) {
    protected abstract val pronoun: String
    abstract var costOfHand: Int
    protected abstract val cardsInHand: MutableList<String>
    protected abstract var numberOfAces: Int

    private val cards: MutableList<Pair<Rank, Suit>> = mutableListOf()

    protected val redColor = "\u001b[31m"
    protected val blueColor =
        "\u001B[34m" // это для дальнейших обновлений, когда мы сможем выводить карту цветом, соответствующим её масти
    protected val greenColor = "\u001B[32m"
    protected val resetColor = "\u001b[0m"

    fun information(): String {
        return """
    **        $name:
            **     the value of $pronoun hand is $greenColor$costOfHand$resetColor,
            **     $pronoun cards are "$redColor${cardsInHand.joinToString(", ")}$resetColor"
        """.trimIndent()
    }

    protected val finish: String by lazy {
        """
            |$name $pronoun finished taking the cards,
            |the value of $pronoun hand is $greenColor$costOfHand$resetColor,
            |$pronoun cards are "$redColor${cardsInHand.joinToString(", ")}$resetColor"
        """.trimMargin()
    }

    init {
        Suit.entries.shuffled().forEach { suit ->
            Rank.entries.shuffled().forEach { rank ->
                cards += rank to suit
            }
        }
    }

    fun takeCard() {
        val tookCard = cards.shuffled().first()

        val typeOfCard = tookCard.first
        val nameOfType = typeOfCard.name.lowercase().capitalize()

        val suitOfCard = tookCard.second
        val nameOfSuit = suitOfCard.name.lowercase().capitalize()

        costOfHand += typeOfCard.cost
        cardsInHand += "$nameOfType $nameOfSuit"
        cards -= Pair(typeOfCard, suitOfCard)

        println("$name is taking a card...")
        Thread.sleep(500)
        println("""it's "$nameOfType of $nameOfSuit" its value is ${typeOfCard.cost}""")

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