package com.example.kotlincoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*fun main() {
    runBlocking {
        val foo = foo(200)
        foo(5).collect {
            println("i = $it")
        }
    }
}*/

fun foo(x: Int): Flow<Int> = flow {
    for (i in 0..x) {
        delay(1000)
        emit(i)
    }
}

fun main() {
    runBlocking {
        /*withTimeoutOrNull(3500){
            foo(10).collect{
                println("i = $it")
            }
        }*/

        /*(1..5).asFlow().collect{
            println(it)
        }

        val array = arrayOf("5", "4", 1,2,4,5,3)
        array.asFlow().collect{
            println("$it")
        }*/

        val list = listOf<Int>(5,9,8,3,53,5)
        list.asFlow().collect{
            println(it)
        }
    }
}