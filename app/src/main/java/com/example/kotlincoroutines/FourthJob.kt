package com.example.kotlincoroutines

import kotlinx.coroutines.*

class FourthJob {
}

/*
fun main() {
    val job: Job = GlobalScope.launch {
        delay(2000)
        println("Hello Kotlin")
    }

    val job2: Job = GlobalScope.launch {
        job.join()
        delay(1000)
        println("I'm Coroutines")
    }

    Thread.sleep(4000)

}*/

/*
fun main() {
    runBlocking {
        val job: Job = launch(Dispatchers.Default) {
            repeat(1000) {
                delay(500)
                println("I'm sleeping $it...")
            }
        }
        delay(1500)
        job.cancel()
        println("Cancelled coroutines")
    }
}*/

/*fun main() {
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch (Dispatchers.Default){
            var nextPrintTime = startTime
            var i = 0
            while (isActive){
                if (System.currentTimeMillis() >= nextPrintTime){
                    println("job: I'm sleeping ${i++}...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now i can quit")
    }
}*/

/*
fun main() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    delay(100)
                    println("Hello Coroutines")
                }
            } finally {
                println("Finally")
                delay(100)
                println("Please print me last times")
            }
        }
        delay(800)
        println("stop coroutines")
        job.cancel()
    }
}*/

/*
fun main() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    delay(100)
                    println("Hello Coroutines")
                }
            } finally {
                println("Finally")
                withContext(NonCancellable){
                    repeat(10){
                        delay(100)
                        println("NonCancelled")
                    }
                }
            }
        }
        delay(2000)
        println("stop coroutines")
        job.cancel()
    }
}*/

/*
fun main() = runBlocking {
    val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
        delay(5000L)
        println("World!")
    }
    println("Hello,")
  //  job.join() // wait until child coroutine completes
    println("Kotlin")
}*/

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    println("main: Now I can quit.")
}