package no.fortedigital.forteflix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CustomerTest {

    @Test
    fun constructor() {
        assertThrows<IllegalArgumentException> {
            Customer("")
        }
        val customer = Customer(name = "OddMagne")
        assertEquals("OddMagne", customer.name)
        assertEquals(0, customer.totalSerieTypesOfInterest())

        val registrationDate = LocalDate.now()
        val customerWithDate = Customer(name = "OddMagne", registrationDate = registrationDate)

        assertEquals(registrationDate, customerWithDate.registrationDate)
    }

    @Test
    fun totalSerieTypesOfInterest() {
        val customer = Customer(name = "OddMagne")

        customer.addSerieTypesOfInterest(SerieType.Talkshow)
        assertEquals(1, customer.totalSerieTypesOfInterest())

        assertTrue(customer.isInterestedIn(setOf(SerieType.Talkshow)))
        assertFalse(customer.isInterestedIn(setOf(SerieType.Humor)))


        customer.removeSerieTypeOfInterest(SerieType.Talkshow)
        assertEquals(0, customer.totalSerieTypesOfInterest())
        assertFalse(customer.isInterestedIn(setOf(SerieType.Talkshow)))
    }
}