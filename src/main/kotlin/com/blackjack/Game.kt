package com.blackjack

import com.blackjack.players.Dealer
import com.blackjack.players.Player
import com.blackjack.players.User

fun main() {
    val playerName = Player.enterName()
    val dealer = Dealer()

    val user = User(playerName)

    val game = Game(user, dealer)
    game.play()
}