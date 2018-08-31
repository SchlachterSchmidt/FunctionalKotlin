package _03functioncomposition

fun main(args: Array<String>) {

    val linkedList = MakeList("Hello", MakeList("World", MakeList("Functional", Nil)))
    println(linkedList)

    linkedList.append(MakeList("Programming", MakeList("Rocks", Nil))).map { println("\t$it") }

    linkedList.filter { it.startsWith("W") }.map { println(it) }

    linkedList.forEach { println("\t$it") }

    linkedList.flatMap { MakeList(it, MakeList("Pretty sweet", Nil)) }.map { println(it) }

    linkedList.append(MakeList("Programming", MakeList("Rocks", Nil)))
        .filter { it.length == 5 }
        .flatMap { MakeList(it, MakeList("@", Nil)) }
        .map { it.length }
        .forEach { println(it) }
}

sealed class FunctionalLinkedList<out T : Any>

data class MakeList<out T : Any>(val head: T, val tail: FunctionalLinkedList<T>) : FunctionalLinkedList<T>() {
    override fun toString(): String = "$head :: $tail"
}

object Nil : FunctionalLinkedList<Nothing>() {
    override fun toString(): String = "nil"
}

tailrec fun <T : Any> FunctionalLinkedList<T>.forEach(f: (T) -> Unit): Unit = when (this) {
    Nil -> Unit
    is MakeList -> {
        f(head)
        tail.forEach(f)
    }
}

fun <T : Any, R : Any> FunctionalLinkedList<T>.map(f: (T) -> R): FunctionalLinkedList<R> = when (this) {
    Nil -> Nil
    is MakeList -> MakeList(f(head), tail.map(f))
}

fun <T : Any, R : Any> FunctionalLinkedList<T>.flatMap(f: (T) -> FunctionalLinkedList<R>): FunctionalLinkedList<R> = when (this) {
    Nil -> Nil
    is MakeList -> f(head).append(tail.flatMap(f))
}

tailrec fun <T : Any> FunctionalLinkedList<T>.filter(f: (T) -> Boolean): FunctionalLinkedList<T> = when (this) {
    Nil -> Nil
    is MakeList -> when (f(head)) {
        true -> MakeList(head, tail.filter(f))
        false -> tail.filter(f)
    }
}

fun <T : Any> FunctionalLinkedList<T>.append(list: FunctionalLinkedList<T>): FunctionalLinkedList<T> = when (this) {
    Nil -> list
    is MakeList -> MakeList(head, tail.append(list))
}