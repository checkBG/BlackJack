package com.black.jack

import com.black.jack.players.Dealer
import com.black.jack.players.PlayerBlackJack
import com.black.jack.players.User

fun main() {
    val playerName = PlayerBlackJack.enterName()
    val dealer = Dealer()

    val user = User(playerName)

    while (user.hand.costOfHand < 21) {
        println("Another card? Yes/No: ")

        if (readln().lowercase() in listOf("y", "yes", "да", "д", "yep", "yeah")) {
            user.takeCard()
        } else if (user.hand.costOfHand < 21) {
            println(dealer.artificialIntelligence())
            break
        } else {
            break
        }
    }

    println(
        """
        |${Game.result(user.hand.costOfHand, dealer.hand.costOfHand)}
        |${user.information()}
        """.trimMargin()
    )

    if (dealer.hand.costOfHand > 0) {
        println(
            """
            |
            |${dealer.information()}
            """.trimMargin()
        )
    }
}