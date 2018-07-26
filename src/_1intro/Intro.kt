package _1intro

fun main(args: Array<String>) {

    val a = unit()
    println(a)

    println(one())

    println(triple(4))
}

// all of these are 'pure functions' without side effects
fun unit(): Unit {
    return Unit
}

fun one() = 1

fun triple(x: Int) = x * 3