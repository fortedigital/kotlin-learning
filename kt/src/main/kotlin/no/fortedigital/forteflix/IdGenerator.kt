package no.fortedigital.forteflix

import java.util.concurrent.atomic.AtomicInteger

private const val INITIAL_COUNTER_VALUE = 1

class IdGen {
    private val idGen = AtomicInteger(INITIAL_COUNTER_VALUE)
    fun getId() = idGen.getAndIncrement()
    internal fun reset() = idGen.set(INITIAL_COUNTER_VALUE)
}