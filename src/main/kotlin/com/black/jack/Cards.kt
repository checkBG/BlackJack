package com.black.jack

enum class Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

enum class Rank(val cost: Int) {
    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10)
}

class Cards {
    private val cards: MutableList<Pair<Rank, Suit>> = mutableListOf()

    init {
        Suit.entries.forEach { suit ->
            Rank.entries.forEach { rank ->
                cards += rank to suit
            }
        }
        cards.shuffle()
    }

    fun getCard(): Pair<Rank, Suit> {
        val getCard = cards.first()
        cards -= getCard
        return getCard
    }
}