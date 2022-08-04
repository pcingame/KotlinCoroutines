package com.example.kotlincoroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SeventhCoroutineScope {
}

fun main() {
    /*CoroutineScope(Dispatchers.IO).launch {
        launch {

        }

        launch {

        }

        async {

        }
    }

    GlobalScope.launch { }

    MyCoroutineScope().launch {

    }*/
    runBlocking {
        /*val job: Job = launch {
            launch {
                delay(100)
                println("coroutines 1 a")
                delay(1000)
                println("coroutines 1 b")
            }

            launch {
                delay(100)
                println("coroutines 2 a")
                delay(1000)
                println("coroutines 2 b")
            }
            GlobalScope.launch {
                delay(100)
                println("C 3: Hello")
                delay(2000)
                println("C 3: Goodbye")
            }
        }
        delay(500)
        job.cancel()
        delay(3000)*/
        val job = launch {
            repeat(3){
                launch {
                    delay(100)
                    println("c $it")
                }
            }
            println("from parent")
        }

        job.join()
        delay(1000)
    }
}

class MyCoroutineScope() : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

}