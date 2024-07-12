package com.black.jack

import com.black.jack.players.PlayerBlackJack
import com.black.jack.utils.Color
import com.black.jack.utils.changeColor

enum class Suit(val suit: String) {
    CLUBS("♣️"),
    DIAMONDS("♦\uFE0F"),
    HEARTS("♥️"),
    SPADES("♠\uFE0F")
}

enum class Rank(val symbol: Char, val cost: Int) {
    ACE('A', 11),
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 10),
    QUEEN('Q', 10),
    KING('K', 10)
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
        val getCard = deck.random()
        deck -= getCard
        return getCard
    }
}