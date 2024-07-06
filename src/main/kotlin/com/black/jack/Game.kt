package com.black.jack

fun main() {
    val playerName = PlayerBlackJack.enterName()
    val dealer = Dealer()

    val player = Player(playerName)

    while (dealer.costOfHand <= 21 &&
        player.costOfHand <= 21 &&
        dealer.costOfHand >= player.costOfHand
    ) {
        player.question()
        if (readln().lowercase() in listOf("y", "yes", "да", "д")) {
            player.oneMoreCard()
        } else {
            break
        }
    }

    println(result(player.costOfHand, dealer.costOfHand))
    println(
        """
        ${player.information()}
        and
        ${dealer.information()}
    """.trimIndent()
    )
}
