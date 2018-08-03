package _01intro

fun main(args: Array<String>) {

    println(sum(5))
    // sum(5)
    // sum(5 + sum(4))
    // sum(5 + sum(4 + sum(3)))
    // sum(5 + sum(4 + sum(3 + sum(2))))
    // sum(5 + sum(4 + sum(3 + sum(2 + sum(1)))))
    // sum(5 + sum(4 + sum(3 + sum(2 + 1))))
    // sum(5 + sum(4 + sum(3 + 3)))
    // sum(5 + sum(4 + 6))
    // sum(5 + 10)
    // 15

    // recursion has some limitations. this is fune
    println(sum(50))

    // but this will cause StackOverflow
    // sum(100000)

    // tail recursion helps us here

    println(sum2(50))
    println(sum2(100000))
}

fun sum(n: Long): Long = when (n) {
    1L -> 1L
    else -> n + sum(n - 1)
}

// in tail recursive functions, the recursive call must be the last function call
// in the above, it may look as if that was the case, but in reality it is the + operation
// if we view the bytecode and decompile we see the implementation is a simple while loop
tailrec fun sum2(n: Long, run: Long = 1): Long = when (n) {
    1L -> run
    else -> sum2(n - 1, run + n)
}