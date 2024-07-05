package com.black.jack

fun result(player: Int, dealer: Int): String {
    return when {
        (((player > dealer) && (player <= 21)) || ((dealer > 21) && (player <= 21))) -> "You won! Congratulations!!!"

        (dealer > 21) -> "Both lost!"

        (player < dealer) || (player > 21) -> "You lost! Oops, it happens"

        else -> "A draw, no one won (But you can definitely do it!)"
    }
}