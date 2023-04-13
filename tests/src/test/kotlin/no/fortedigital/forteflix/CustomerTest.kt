package no.fortedigital.forteflix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import kotlin.test.assertEquals

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

        customer.addSerieTypeOfInterest(SerieType.Talkshow)
        assertEquals(1, customer.totalSerieTypesOfInterest())

        customer.removeSerieTypeOfInterest(SerieType.Talkshow)
        assertEquals(0, customer.totalSerieTypesOfInterest())
    }
}