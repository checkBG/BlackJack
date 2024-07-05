package com.black.jack

fun main() {
    val playerName = PlayerBlackJack.enterName()
    val dealer = Dealer()

    val player = Player(playerName)

    player.question()
    while (readln().lowercase() in listOf(
            "y", "yes", "да", "д"
        ) && dealer.costOfHand <= 21 && player.costOfHand <= 21
    ) {
        player.oneMoreCard()
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
