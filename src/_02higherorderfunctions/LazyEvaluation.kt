package _02higherorderfunctions

fun main(args: Array<String>) {

    // here we pass both lists to the function
    sth(listOf("a", "b", "c"), listOf(1, 2, 3), false)

    lazySth({ listOf("a", "b", "c") }, { listOf(1, 2, 3) }, true)

    // lazily creating an infinite list of numbers. we have all the numbers, but only when we really need them
    val seq = generateSequence(0, { it.inc() })
    seq.take(10).forEach { println(it) }
}

fun sth(a: Any, b: Any, isFirst: Boolean) = if (isFirst) println(a) else println(b)

fun lazySth(a: () -> Any, b: () -> Any, isFirst: Boolean) = if (isFirst) println(a.invoke()) else println(b.invoke())