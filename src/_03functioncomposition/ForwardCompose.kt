package _03functioncomposition

fun main(args: Array<String>) {

    val doubleStrAndThenLen = ::doubleStr.andThen(::len)
    println(doubleStrAndThenLen("hello"))

    val c = ::doubleStr
        .andThen(::len)
        .andThen(::triple)

    println(c("World"))

    val strList = listOf("string1", "string2", "string3")

    // while we can do this, Map creates a new list at every step along the way
    strList.map(::doubleStr)
        .map(::len)
        .map(::triple)
        .forEach { println("$it") }

    // like this, we only create one new list
    strList.map(c)
        .forEach { println("$it") }
}

fun <T1, T2, R> ((T1) -> T2).andThen(f: (T2) -> R): (T1) -> R = {
    t1 -> f(this(t1))
}

fun doubleStr(s: String): String = s + s

fun len(s: String) = s.length

fun triple(i: Int) = i * 3