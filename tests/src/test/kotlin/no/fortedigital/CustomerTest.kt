package no.fortedigital

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CustomerTest {
    @Test
    fun `prints name`() {
        val customer = Customer("Charlie")
        assertEquals("CHARLIE", customer.uppercased())
    }
}