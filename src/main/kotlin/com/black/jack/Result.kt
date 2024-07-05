package com.black.jack

fun result(player: Int, dealer: Int): String {
    return when {
        ((player > dealer) || ((dealer > 21) && (player <= 21))) -> "You won! Congratulations!!!"

        (player < dealer) -> "You lost! Oops, it happens"

        else -> "A draw, no one won (But you can definitely do it!)"
    }
}