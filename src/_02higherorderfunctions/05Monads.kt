package _02higherorderfunctions

import java.util.Optional

fun main(args: Array<String>) {

    // monad is a wrapper around data that provides additional properties
    // (this explanation is quite ...thin?)

    // lambda in map is applied to every element in the list
    var x = listOf(1, 2, 3, 4, 5).map { it -> it * 2 }
    println(x)

    // flatmap will prduce element of the same monad
    val y = listOf(1, 2, 3, 4, 5).flatMap { it -> listOf(it, it * 2) }
    println(y)

    // using the map and flatMap methods of our mondad Container
    val c = Container<Int>(2).map { "-$it-" }
    println(c)
    val d = Container(3).flatMap { Container(it + 4) }
    println(d)

    // common in functional programming are Optionals, which may be null. Two ways to create them are:
    Optional.of(2)
    Optional.empty<Int>()

    // if we have a value, we will perform the map / flatMap operation
    val m = Optional.of(3).map { it * 3 }.flatMap { Optional.of(it * 3) }
    println(m)

    // if not, we do nothing. this is a nice way to deal with NPE
    val n = Optional.empty<Int>().map { it * 3 }.flatMap { Optional.of(it * 3) }
    println(n)
}

data class Container<T>(private val obj: T) {
    fun <R> map(transformer: (T) -> R): Container<R> = Container(transformer(obj))
    fun <R> flatMap(transformer: (T) -> Container<R>) = transformer(obj)
}