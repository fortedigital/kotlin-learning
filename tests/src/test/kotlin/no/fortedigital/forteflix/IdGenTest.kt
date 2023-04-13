package no.fortedigital.forteflix

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IdGenTest {

    @Test
    fun getId() {
        assertEquals(1, IdGen.getId())
        assertEquals(2, IdGen.getId())
    }
}