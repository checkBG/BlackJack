package com.black.jack.model

import com.black.jack.Rank
import com.black.jack.Suit

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