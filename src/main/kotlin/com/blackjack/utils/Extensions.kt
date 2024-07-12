package com.blackjack.utils

fun <T> T.changeColor(color: Color): String {
    return color.color + this.toString() + Color.RESET.color
}