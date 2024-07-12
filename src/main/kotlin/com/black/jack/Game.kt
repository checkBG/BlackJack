package com.black.jack

import com.black.jack.players.Dealer
import com.black.jack.players.Player
import com.black.jack.players.PlayerBlackJack

fun main() {
    val playerName = PlayerBlackJack.enterName()
    val dealer = Dealer()

    val player = Player(playerName)

    while (dealer.costOfHand <= 21 &&
        player.costOfHand < 21 &&
        dealer.costOfHand >= player.costOfHand
    ) {
        player.question()
        if (readln().lowercase() in listOf("y", "yes", "да", "д", "yep", "yeah")) {
            player.takeCard()
        } else {
            break
        }
    }

    println(
        """
        |${result(player.costOfHand, dealer.costOfHand)}
        |${player.information()}
        |
        |${dealer.information()}
    """.trimMargin()
    )
}