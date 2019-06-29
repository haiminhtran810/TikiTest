package com.hai.demo.extension


const val BREAK_NUMBER = 2

fun String.breakLineForString(): String {
    val listString = this.trim().split("\\s".toRegex())
    return when {
        listString.size == BREAK_NUMBER -> {
            this.replace("\\s+".toRegex(), "\n")
        }
        listString.size > BREAK_NUMBER -> {
            val numberTemp = listString.size / 2
            // if it is even number or odd number
            if (listString.size % 2 == 0) {
                this.replace(listString[numberTemp], listString[numberTemp] + "\n")
            } else {

                var first = 0
                for (i in 0..numberTemp) {
                    first += listString[i].length
                }

                val second = this.length - first + listString[numberTemp].length

                if (first >= second) {
                    this.replace(listString[numberTemp], "\n" + listString[numberTemp])
                } else {
                    this.replace(listString[numberTemp], listString[numberTemp] + "\n")
                }
            }
        }
        else -> this
    }
}