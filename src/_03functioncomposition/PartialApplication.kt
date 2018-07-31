package _03functioncomposition

fun main(args: Array<String>) {

    // storing the lambda in p100
    val p100 = ::price.partial1(100.0)
    // and calling the lambda with
    val res = p100(0.20, 10.0)
    println(res)
}

// partial application is a technique to reduce the number of arguments
fun price(originalPrice: Double, pDiscount: Double, fDiscount: Double) =
    originalPrice * (1 - pDiscount) - fDiscount

// this is the 'plain' version
fun price100(pDiscount: Double, fDiscount: Double) =
    price(100.0, pDiscount, fDiscount)

// using generics
// an extension function to any function that matches the generics: 3 params, 1 return value
// partial 1 takes one arg, and returns a function
// which takes two arguments and returns another val
// the implementaion is to use invoke method of the function that is being extended with all three params
fun <T1, T2, T3, R> ((T1, T2, T3) -> R).partial1(t1: T1): (T2, T3) -> R =
    { t2, t3 -> this.invoke(t1, t2, t3) }