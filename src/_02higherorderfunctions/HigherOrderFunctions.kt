package _02higherorderfunctions

fun main(args: Array<String>) {

    // make twoAndThree multiply two by three
    val x = twoAndThree { a, b -> a * b }
    // or not, depending on the predicate.
    val y = twoAndThree { a, b -> a + b }
    // or add the squares
    twoAndThree { a, b -> (a * a) + (b * b) }

    // prints the function signature
    println(lengthOfString())
    // to use the function we have to use a funny syntax lengthOfString()("some prameter")
    println(lengthOfString()("how long is this string?"))
    // or we use the invoke method lengthOfString().invoke("some string")
    println(lengthOfString().invoke("this is how long I am"))
}

// twoAndThree is a function that accepts another function as argument
// the lambda's signature is (Int, Int) -> Int. twoAndThree returns an Int
fun twoAndThree(operation: (Int, Int) -> Int): Int {
    val result = operation(2, 3)
    println("the result is $result")
    return result
}

// lengthOfString is a function that returns another function
fun lengthOfString(): (String) -> Int {
    return { s -> s.length }
}