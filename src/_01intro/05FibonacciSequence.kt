package _01intro

fun main(args: Array<String>) {
    println(fib(0))
    println(fib(1))
    println(fib(2))
    println(fib(3))
    println(fib(4))
    println(fib(5))
}

fun fib(n: Long): Long = when (n) {
    0L -> 0L
    1L -> 1L
    else -> fib(n - 1) + fib(n - 2)
}