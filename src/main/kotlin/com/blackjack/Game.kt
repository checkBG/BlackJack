package com.blackjack

import com.blackjack.players.Dealer
import com.blackjack.players.PlayerBlackjack
import com.blackjack.players.User

fun main() {
    val playerName = PlayerBlackjack.enterName()
    val dealer = Dealer()

    val user = User(playerName)

    val game = Game(user, dealer)
    game.play()
}