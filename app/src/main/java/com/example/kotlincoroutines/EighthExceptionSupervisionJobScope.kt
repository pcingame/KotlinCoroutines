package com.example.kotlincoroutines

import androidx.core.app.NavUtils
import kotlinx.coroutines.*
import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException

class EighthExceptionSupervisionJobScope {
}

/*
fun main() {
    runBlocking {
        GlobalScope.launch {
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException()
            println("Unreached")
        }
    }
}*/

/*
fun main() {
    runBlocking {
        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException()
            println("Unreached")
        }
        deferred.await()
    }
}*/

/*
fun main() {
    runBlocking {
        try {
            GlobalScope.launch {
                println("Throwing exception from launch")
                throw IndexOutOfBoundsException()
                println("Unreached")
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Caught IndexOutOfBoundsException")
        }
        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException()
            println("Unreached")
        }

        try {
            deferred.await()
            println()
        } catch (e: ArithmeticException) {
            println("Caught ArithmeticException")
        }
    }
}*/

/*
fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Error here: ${exception.toString()}")

        }

        val job = GlobalScope.launch(handler + Dispatchers.Default) {
            println("Throw Exception from launch")
            throw NullPointerException()
        }

        job.join()

        val deferred = GlobalScope.async(handler) {
            println("Throw Exception from async")
            throw IndexOutOfBoundsException()
        }
        try {
            deferred.await()
        } catch (e: IndexOutOfBoundsException) {
            println(e.toString())
        }
    }
}*/

/*
fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler{_, exception ->
            println("Exception: $exception")
        }

        val job = GlobalScope.launch {
            launch {
                println("C 1")
                delay(300)
                throw IndexOutOfBoundsException("C 1")
            }

            launch {
                println("C 2")
                delay(200)
                throw NullPointerException("C 2")
            }

            launch {
                println("C 3")
                delay(400)
                throw ArithmeticException("C 3")
            }
        }
        job.join()
    }
}*/

/*
@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler{_, exception ->
            println("Exception: $exception with suppressed ${exception.suppressed.contentToString()}")
        }

        val job = GlobalScope.launch(handler) {
            launch {
                println("C1")
                delay(300)
                println("C1 c")
                throw IndexOutOfBoundsException("C 1")
            }

            launch {
                try {
                    delay(Long.MAX_VALUE)
                }finally {
                    throw ArithmeticException("C 2")
                }
            }

            launch {
                println("C3")
                delay(400)
                println("C3 3")
                throw ArithmeticException("C 3")
            }
        }
        job.join()
        delay(1000)
    }
}*/

//part 3
/*
fun main() {
    runBlocking {
        val supervisionJob = SupervisorJob()
        with(CoroutineScope(coroutineContext + supervisionJob)) {
            val firstChild = launch {
                println("Print from First Child")
                throw NullPointerException()
            }

            val secondChild = launch {
                firstChild.join()
                println("Print from second Child. First Child is Active: ${firstChild.isActive}")
                try {
                    delay(1000)
                }finally {
                    println("Second Child Cancelled")
                }
            }
            firstChild.join()
            println("Cancelling SuperVisorJob")
            supervisionJob.cancel()
            secondChild.isActive
        }
    }
}*/

fun main() {
    runBlocking {
      //  val supervisionJob = SupervisorJob()
        supervisorScope {
            val firstChild = launch {
                println("Print from First Child")
                throw NullPointerException()
            }

            val secondChild = launch {
                firstChild.join()
                println("Print from second Child. First Child is Active: ${firstChild.isActive}")
                try {
                    delay(1000)
                } finally {
                    println("Second Child Cancelled")
                }
            }
            firstChild.join()
            secondChild.join()
        }
    }
}