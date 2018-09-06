package _05arrow

import arrow.core.Either
import arrow.core.Id
import arrow.core.Option
import arrow.data.Ior

fun main(args: Array<String>) {
    // Id monad is a plain, pure value monad
    Id.just(1)
        .map { it * 2 }
        .flatMap { Id.just( it * 2) }
        .value

    // option represents one of two cases: value or absence of value
    Option.just(1)
    Option.empty<String>()

    // Either contains one of two values: left or right
    // - left represents typically success
    // - right reperesents failure
    Either.left(1)
    Either.right(RuntimeException())

    // Ior can represent left, or right, or both
    Ior.bothNel(12, 13).isBoth
}