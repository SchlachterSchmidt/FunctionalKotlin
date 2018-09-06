package _04sealedclasses_algebraictypes_coroutines

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.lang.Thread.sleep

fun main(args: Array<String>) {

    val job1 = async {
        delay(1000)
        "Hello"
    }

    val job2 = async {
        delay(1000)
        "World"
    }

    // launch runs the jobs in a non-blocking way
    launch {
        val text = "${ job1.await() } ${ job2.await() }"
        println(text)
    }
    // because launch is non-blocking, we need to suspend for a few seconds to see the output
    sleep(3000)

    // same as launch,  but blocking
    runBlocking {
        val text = "${ job1.await() } ${ job2.await() }"
        println(text)
    }
}