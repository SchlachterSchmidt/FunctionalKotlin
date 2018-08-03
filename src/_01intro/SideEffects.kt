package _01intro

var global = 0

fun main(args: Array<String>) {

    println(first(1)) // prints 1
    println(first(1)) // prints 2

    println(second()) // prints 4
    println(second()) // prints 4

    println(first(2)) // prints 3
    println(second()) // prints 6

    // all these functions produce different output, even when called with the same input. they are impure
}

fun first(x: Int) = global++ + 1

fun second() = global * 2