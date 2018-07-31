package _03functioncomposition

fun main(args: Array<String>) {

    // storing the curried function in lenSumFun
    val lenSumFun = ::lenSum.curried()

    // and passing one argument at a time. this is a useful technique for dependency injection.
    val firstArg = lenSumFun("Hello")
    val secondArg = firstArg("World")
    println(secondArg)

    // alternatively we can call the function ref immediately with two variables
    println(lenSumFun("hello")("world"))
}

fun lenSum(s1: String, s2: String): Int = s1.length + s2.length

fun <T1, T2, R> ((T1, T2) -> R).curried(): (T1) -> (T2) -> R =
    { t1 -> { t2 -> this(t1, t2) } }