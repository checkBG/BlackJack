package com.blackjack.utils

enum class Color(val color: String) {
    RED("\u001b[31m"),
    BRIGHT_RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    BRIGHT_BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    WHITE("\u001B[47m"),
    BRIGHT_WHITE("\u001B[97m"),
    YELLOW("\u001B[33m"),
    RESET("\u001b[0m")
}