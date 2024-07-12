package com.black.jack

import com.black.jack.players.Dealer
import com.black.jack.players.User
import com.black.jack.players.PlayerBlackJack

fun main() {
    val playerName = PlayerBlackJack.enterName()
    val dealer = Dealer()

    val user = User(playerName)

    while (dealer.hand.costOfHand <= 21 &&
        user.hand.costOfHand < 21 &&
        dealer.hand.costOfHand >= user.hand.costOfHand
    ) {
        user.question()
        if (readln().lowercase() in listOf("y", "yes", "да", "д", "yep", "yeah")) {
            user.takeCard()
        } else {
            break
        }
    }

    println(
        """
        |${Game.result(user.hand.costOfHand, dealer.hand.costOfHand)}
        |${user.information()}
        |
        |${dealer.information()}
    """.trimMargin()
    )
}