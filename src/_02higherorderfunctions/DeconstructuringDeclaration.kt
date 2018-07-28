package _02higherorderfunctions

fun main(args: Array<String>) {

    var pair = "One" to 1
    println(pair.first)
    println(pair.component1())

    mapOf(1 to "One", 2 to "Two", 3 to "Three").forEach { (a, b) -> println("first $a then $b") }
}