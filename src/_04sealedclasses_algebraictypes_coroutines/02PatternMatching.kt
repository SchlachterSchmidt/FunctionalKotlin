package _04sealedclasses_algebraictypes_coroutines

fun main(args: Array<String>) {

    val s: State = State.Success("Successful operation")

    when (s) {
        // upon match, s is automatically casted so we can access attributes
        is State.Error -> print(s.error)
        is State.Loading -> print("loading")
        is State.Success -> print(s.result)
        // the compiler will check that we process all states in the when statement
    }
}