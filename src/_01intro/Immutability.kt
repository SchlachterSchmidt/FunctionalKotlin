package _01intro

fun main(args: Array<String>) {

    val john = Person("John", 22)
    // cannot reassign age, but rather create a new object with different attributes. This is how we can manage state
    john.copy(age = 23)
    // johns age remains unchanged
    println(john)
}

data class Person(val name: String, val age: Int)