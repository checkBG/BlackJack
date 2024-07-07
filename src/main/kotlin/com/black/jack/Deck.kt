package com.black.jack

enum class Suit(val suit: String) {
    CLUBS("♣️"),
    DIAMONDS("♦\uFE0F"),
    HEARTS("♥️"),
    SPADES("♠\uFE0F")
}

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

class Deck {
    private val deck: MutableList<Pair<Rank, Suit>> = mutableListOf()

    init {
        Suit.entries.forEach { suit ->
            Rank.entries.forEach { rank ->
                deck += rank to suit
            }
        }
        deck.shuffle()
    }

    fun getCard(): Pair<Rank, Suit> {
        val getCard = deck.first()
        deck -= getCard
        return getCard
    }
}