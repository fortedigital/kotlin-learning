package no.fortedigital

import no.fortedigital.forteflix.IdGen
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IdGenTest {

    private val idGenerator = IdGen()

    @Test
    fun getId() {
        idGenerator.reset()
        assertEquals(1, idGenerator.getId())
        assertEquals(2, idGenerator.getId())
    }
}