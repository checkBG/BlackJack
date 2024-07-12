package com.blackjack

import com.blackjack.players.Dealer
import com.blackjack.players.User
import com.blackjack.utils.Color
import com.blackjack.utils.changeColor

class Game(private val user: User, private val dealer: Dealer) {
    companion object {
        val deck = Deck()
    }

    private fun result(player: Int, dealer: Int): String {
        return when {
            (((player > dealer) && (player <= 21)) || (dealer > 21)) -> "You ${"won".changeColor(color = Color.BRIGHT_RED)}! Congratulations!!!"

            (dealer == 0) -> "You lost, you had too much, the dealer didn't even take the cards!"

            (player < dealer) || (player > 21) -> {
                val smile = listOf("(｡•́︿•̀｡)", "(っ◞‸◟c)", "ಥ_ಥ").random()
                "You ${"lost".changeColor(color = Color.BRIGHT_WHITE)}! ${smile.changeColor(color = Color.BRIGHT_WHITE)} Oops, it happens"
            }

            else -> "A ${"draw".changeColor(color = Color.BRIGHT_BLUE)}, no one won (But you can definitely do it!)"
        }
    }

    fun play() {
        while (user.hand.costOfHand < 21) {
            println(user.information())
            println("Another card? Yes/No: ")

            if (readln().lowercase() in listOf("y", "yes", "да", "д", "yep", "yeah")) {
                user.takeCard()
            } else if (user.hand.costOfHand <= 21) {
                dealer.artificialIntelligence()
                break
            } else {
                break
            }
        }

        println(
            """
        |${result(user.hand.costOfHand, dealer.hand.costOfHand)}
        |${user.information()}
        |
        """.trimMargin()
        )

        if (dealer.hand.costOfHand > 0) {
            println(dealer.information())
        }
    }
} // ЗДЕСЬ БУДЕТ КОД И ЛОГИКА, если Андрей скажет, что так нужно