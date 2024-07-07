package com.black.jack

fun <T> T.changeColor(color: Color): String {
    return color.color + this.toString() + Color.RESET.color
}