package _04sealedclasses_algebraictypes_coroutines

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) {

    val job = async {

        delay(1000)
    }
}