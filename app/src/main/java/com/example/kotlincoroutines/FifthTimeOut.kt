package com.example.kotlincoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

class FifthTimeOut {
}

/*
fun main() {
    runBlocking {
        withTimeout(1600L){
            repeat(1000){
                println("I'm sleeping... $it")
                delay(500L)
            }
        }
    }
}*/

fun main() {
    runBlocking {
        val result = withTimeoutOrNull(1600L) {
            repeat(1000) {
                println("I'm sleeping... $it")
                delay(500)
            }
            ""
        }
        println("Result is $result")
    }
}