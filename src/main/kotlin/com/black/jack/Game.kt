package com.black.jack

import com.black.jack.players.Dealer
import com.black.jack.players.PlayerBlackJack
import com.black.jack.players.User

fun main() {
    val playerName = PlayerBlackJack.enterName()
    val dealer = Dealer()

    val user = User(playerName)

    val game = Game(user, dealer)
    game.play()
}