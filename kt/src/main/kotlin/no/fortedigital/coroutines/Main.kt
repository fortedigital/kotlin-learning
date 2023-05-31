package no.fortedigital.coroutines

import kotlinx.coroutines.runBlocking
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {
    println(basicCoroutine())
}

suspend fun basicCoroutine() = suspendCoroutine { continuation ->
    continuation.resumeWith(Result.success("My coroutine"))
}