package com.example.kotlincoroutines

import android.util.Log
import kotlinx.coroutines.*

object ThirdWithContext {
    fun testMyFirstWithContext() {
        newSingleThreadContext("Thread 1").use { context1 ->
            Log.d(
                MainActivity::class.java.simpleName,
                "Context 1 - Thread: ${Thread.currentThread().name}"
            )
            newSingleThreadContext("Thread 2").use { context2 ->
                Log.d(
                    MainActivity::class.java.simpleName,
                    "Context 2 - Thread: ${Thread.currentThread().name}"
                )
                runBlocking(context1) {
                    Log.d(
                        MainActivity::class.java.simpleName,
                        "Working in Context 1 - Thread: ${Thread.currentThread().name}"
                    )
                    withContext(context2) {
                        Log.d(
                            MainActivity::class.java.simpleName,
                            "Context 2 - Thread: ${Thread.currentThread().name}"
                        )
                    }
                    Log.d(
                        MainActivity::class.java.simpleName,
                        "Back to Context 1 - Thread: ${Thread.currentThread().name}"
                    )
                }
            }
        }
    }

    fun testMySecondWithContextFunc() {
        GlobalScope.launch(Dispatchers.IO) {
            //Run log time task
            Log.d(MainActivity::class.java.simpleName, "Run long time task - Thread: ${Thread.currentThread().name}")
            delay(2000L)
            withContext(Dispatchers.IO) {
                //Update UI here
                Log.d(MainActivity::class.java.simpleName, "Update UI - Thread: ${Thread.currentThread().name}")

            }
        }
    }
}