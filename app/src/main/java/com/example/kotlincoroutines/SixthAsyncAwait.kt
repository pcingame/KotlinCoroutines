package com.example.kotlincoroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class SixthAsyncAwait {
}

suspend fun printOne(): Int {
    delay(1000)
    return 10
}

suspend fun printTwo(): Int {
    delay(1000)
    return 20
}

fun printInt(): Int {
    return 10
}

/*
fun main() {
    runBlocking<Unit> {
        val time = measureTimeMillis {
            val one = printOne()
            val two = printTwo()
            println("Answer: ${one + two}")
        }
        println("Completed in $time")
    }
}*/

/*
fun main() {
    runBlocking {
        val int: Deferred<Int> = async { printInt() }
        val str: Deferred<String> = async { return@async "Sun" }
        val unit: Deferred<Unit> = async {  }

        println("Int = ${int.await()}")
        println("String = ${str.await()}")
    }
}*/

/*
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one: Deferred<Int> = async { printOne() }
            val two: Deferred<Int> = async { printTwo() }
            println("Answer = ${one.await() + two.await()}")
        }
        println("time: $time")
    }
}*/

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async ( start = CoroutineStart.LAZY ){ printOne()}
            val two = async(start = CoroutineStart.LAZY){ printTwo()}
            one.start()
            two.start()
            println("Answer = ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}
