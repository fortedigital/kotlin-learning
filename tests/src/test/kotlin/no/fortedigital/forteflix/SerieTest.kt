package no.fortedigital.forteflix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class SerieTest {
    @Test
    fun constructor() {
        assertThrows<IllegalArgumentException> {
            Serie(title = "Min serie", types = setOf())
        }
        assertThrows<IllegalArgumentException> {
            Serie(title = "", types = setOf(SerieType.Drama))
        }
        assertDoesNotThrow {
            Serie(title = "Min serie", types = setOf(SerieType.Drama))
        }
    }

    @Test
    fun `add and removeserie type`() {
        val serie = Serie(title = "Min serie", types = setOf(SerieType.Drama))
        serie.addSerieType(SerieType.Drama)
        assertEquals(1, serie.totalSerieTypes())

        serie.addSerieType(SerieType.Humor)
        assertEquals(2, serie.totalSerieTypes())

        serie.removeSerieType(SerieType.Humor)
        assertEquals(1, serie.totalSerieTypes())

        serie.removeSerieType(SerieType.Talkshow)
        assertEquals(1, serie.totalSerieTypes())

        assertThrows<IllegalArgumentException> {
            serie.removeSerieType(SerieType.Drama)
        }
        assertEquals(1, serie.totalSerieTypes())
    }

    @Test
    fun interestWeight() {
        val serie = Serie(title = "Min serie", types = setOf(SerieType.Drama, SerieType.Krim, SerieType.Animasjon))
        val customer = Customer(name = "Customer").apply {
            addSerieTypesOfInterest(SerieType.Drama, SerieType.Krim, SerieType.Reality)
        }
        val notInterestedAnything = Customer(name = "Not interested").apply {
            addSerieTypesOfInterest(SerieType.Reality)
        }
        assertEquals(0, serie.interestWeight(notInterestedAnything))
        assertEquals(2, serie.interestWeight(customer))
    }
}