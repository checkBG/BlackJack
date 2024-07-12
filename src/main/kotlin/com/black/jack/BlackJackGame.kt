package com.black.jack

import com.black.jack.utils.Color
import com.black.jack.utils.changeColor

class Game() {
    companion object {
        val deck = Deck()

        fun result(player: Int, dealer: Int): String {
            return when {
                (((player > dealer) && (player <= 21)) || (dealer > 21)) -> "You ${"won".changeColor(color = Color.BRIGHT_RED)}! Congratulations!!!"

                (dealer == 0) -> "You lost, you had too much, the dealer didn't even take the cards"

                (player < dealer) || (player > 21) -> {
                    val smile = listOf("(｡•́︿•̀｡)", "(っ◞‸◟c)", "ಥ_ಥ").random()
                    "You ${"lost".changeColor(color = Color.BRIGHT_WHITE)}! ${smile.changeColor(color = Color.BRIGHT_WHITE)} Oops, it happens"
                }

                else -> "A ${"draw".changeColor(color = Color.BRIGHT_BLUE)}, no one won (But you can definitely do it!)"
            }
        }
    }
} // ЗДЕСЬ БУДЕТ КОД И ЛОГИКА