package no.fortedigital.forteflix

import java.util.concurrent.atomic.AtomicInteger

object IdGen {
    private val idGen = AtomicInteger(1)
    fun getId() = idGen.getAndIncrement()
}