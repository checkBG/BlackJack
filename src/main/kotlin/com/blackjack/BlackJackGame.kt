package com.blackjack

import com.blackjack.players.Dealer
import com.blackjack.players.User
import com.blackjack.utils.Color
import com.blackjack.utils.changeColor

class Game(private val user: User, private val dealer: Dealer) {
    companion object {
        val deck = Deck()
    }

    private fun result(): String {
        return when {
            (dealer.hand.costOfHand == 21 && dealer.hand.cardsInHand.size == 2 && user.hand.costOfHand != 21) -> "The dealer has blackjack, you have lost"

            (((user.hand.costOfHand > dealer.hand.costOfHand) && (user.hand.costOfHand <= 21)) || (dealer.hand.costOfHand > 21) || user.hand.costOfHand == 21) -> "You ${
                "won".changeColor(
                    color = Color.BRIGHT_RED
                )
            }! Congratulations!!!"

            (dealer.hand.cardsInHand.size == 1) -> "You lost, you had too much, the dealer didn't even take the cards!" // одна карта по умолчанию,
            // потому что по правилам игры крупье раздаёт всем по две карты, а себе только одну, но в случае перебора игрока или набора им 21 очка дилер не берёт карты,
            // а значит если игрок брал одну карту, то проиграл, потому что проверка на 21 было выше

            (user.hand.costOfHand < dealer.hand.costOfHand) || (user.hand.costOfHand > 21) -> {
                val smile = listOf("(｡•́︿•̀｡)", "(っ◞‸◟c)", "ಥ_ಥ").random()
                "You ${"lost".changeColor(color = Color.BRIGHT_WHITE)}! ${smile.changeColor(color = Color.BRIGHT_WHITE)} Oops, it happens"
            }

            else -> "A ${"draw".changeColor(color = Color.BRIGHT_BLUE)}, no one won (But you can definitely do it!)"
        }
    }

    fun play() {
        while (user.hand.costOfHand <= 21) {
            println(user.information())
            println("Another card? Yes/No: ")

            if (readln().lowercase() in listOf(
                    "карту",
                    "ещё",
                    "да",
                    "д",
                    "y",
                    "yes",
                    "yep",
                    "yeah",
                    "card",
                    "hit me"
                ) && user.hand.costOfHand < 21
            ) {
                user.takeCard()
            } else if (
                user.hand.costOfHand < 21 ||
                (user.hand.costOfHand == 21 && dealer.hand.costOfHand in 10..11)
            ) {
                dealer.setOfCardsByDealer()
                break
            } else {
                break
            }
        }

        println(
            """
        |${result()}
        |${user.information()}
        |
        |${dealer.information()}
            """.trimMargin()
        )
    }
} // ЗДЕСЬ БУДЕТ КОД И ЛОГИКА, если Андрей скажет, что так нужно