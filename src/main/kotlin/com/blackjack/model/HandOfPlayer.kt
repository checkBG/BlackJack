package com.blackjack.model

import com.blackjack.Rank
import com.blackjack.Suit

data class Hand(
    var costOfHand: Int = 0,
    val cardsInHand: MutableList<String> = mutableListOf(),
    var numberOfAces: Int = 0
)

data class ReceivedCard(
    val rankOfCard: Rank,
    val nameOfRank: String = rankOfCard.name.lowercase().replaceFirstChar { it.uppercase() },
    val suitOfCard: Suit,
    val nameOfSuit: String = rankOfCard.name.lowercase().replaceFirstChar { it.uppercase() }
)