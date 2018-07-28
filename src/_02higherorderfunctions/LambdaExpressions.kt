package _02higherorderfunctions

import _1intro.one

fun main(args: Array<String>) {

    // this is a lambda with signature () -> kotlin.String
    run { "something" }

    // we can assign this expression to a variable
    val sth = { "something" }

    // and call it like so
    sth()

    // for demo
    println(sth())

    // sth() is equal to sth.invoke()
    sth.invoke()

    // in fact, a lambda expression is a whole class with only one method: invoke
    // the number of arguments for invoke depends on the number of arguments for the lambda

    // lambda with one argument
    val oneArg = { s: String -> s }
    oneArg("hello")
    oneArg.invoke("hello")

    // by convention, unused arguments are symbolized by an underscore
    val twoArgs = { s: String, _: String -> s}
    println(twoArgs("a", "b"))
}