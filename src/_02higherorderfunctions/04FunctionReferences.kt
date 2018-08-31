package _02higherorderfunctions

fun main(args: Array<String>) {

    // this lambda uses the function declared below, which is quite a long declaration
    val l: (String, String) -> Int = { s1, s2 -> a(s1, s2) }
    println(l("asd", "dsa"))
    // the short version of this is
    val l2 = ::a
    println(l2("asd", "dsa"))

    // this syntax can be useful for example
    listOf("hello", "world").map { it.length }.forEach(::println)
}

fun a(s1: String, s2: String): Int = s1.length + s2.length