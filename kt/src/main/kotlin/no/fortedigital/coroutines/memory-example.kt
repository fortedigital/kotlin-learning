package no.fortedigital.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun oom() {
    repeat(50_000) {
        thread {
            Thread.sleep(5000L)
            print(".")
        }
    }
}

suspend fun lightweight() = coroutineScope {
    repeat(50_000) {
        launch {
            delay(5000L)
            print(".")
        }
    }
}