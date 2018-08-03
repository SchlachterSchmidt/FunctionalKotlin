package _01intro

fun main(args: Array<String>) {

    val result = ints()
    // to multiply the two values we need to cast them to int. Not very convenient
    result.a as Int * result.b as Int

    // compiler can infer type of a and b
    val result2 = Tuple2(1, 2)
    result2.a * result2.b
}

data class Tuple(val a: Any, val b: Any)

fun ints() = Tuple(1, 2)

data class Tuple2<T, R>(val a: T, val b: R)

// compiler can infer types
fun ints2() = Tuple2(1, 2)