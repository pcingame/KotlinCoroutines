package com.example.kotlincoroutines

import android.util.Log
import kotlinx.coroutines.*

object SecondDispatchers {
    fun runMyFirstCoroutines() {
        /*GlobalScope.launch(Dispatchers.Default) {
            Log.d(
                MainActivity::class.java.simpleName,
                "Dispatchers Default on ${Thread.currentThread().name} "
            )
        }

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(
                MainActivity::class.java.simpleName,
                "Dispatchers IO run on ${Thread.currentThread().name} "
            )
        }*/

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(
                MainActivity::class.java.simpleName,
                "Dispatchers Main run on ${Thread.currentThread().name} "
            )
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(
                MainActivity::class.java.simpleName,
                "Before Dispatchers Unconfined run on ${Thread.currentThread().name} "
            )
            delay(1000L)
            Log.d(
                MainActivity::class.java.simpleName,
                "Dispatchers Unconfined run on ${Thread.currentThread().name} "
            )
        }
       /* GlobalScope.launch(newSingleThreadContext("My Thread")) {
            Log.d(
                MainActivity::class.java.simpleName,
                "run on ${Thread.currentThread().name} "
            )
        }*/

    }
}