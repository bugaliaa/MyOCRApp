package com.example.core.network

import kotlinx.coroutines.delay
import java.io.IOException

private const val MAX_REPEAT_TIMES = 4
private const val INITIAL_DELAY: Long = 100
private const val MAX_DELAY: Long = 5000

suspend fun <T> withRetry(block: suspend () -> T): T {
    var currentDelay = INITIAL_DELAY
    repeat(MAX_REPEAT_TIMES - 1) {
        try {
            return block()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        delay(currentDelay)
        currentDelay = (currentDelay * 2.0).toLong().coerceAtMost(MAX_DELAY)
    }
    return block()
}