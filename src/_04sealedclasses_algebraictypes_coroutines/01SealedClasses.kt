package _04sealedclasses_algebraictypes_coroutines

fun main(args: Array<String>) {

    // creating an error state object
    val error = State.Error(Throwable(message = "I am a throwable"))

    // this is very powerful with pattern matching
}

// sealed classes can have classes..
sealed class State {
    class Error(val error: Throwable) : State()
    class Success(val result: String) : State()
    class Loading : State()
}

// ..objects..
sealed class Operation {
    object Plus : Operation()
    object Minus : Operation()
}

// ..or both
sealed class Optional {
    class Some(val obj: Any) : Optional()
    object None : Optional()
}