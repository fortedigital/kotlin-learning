package no.fortedigital

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CustomerTest {

    @Test
    fun `myNameTho`() {
        val customer = Customer("Charlie")
        assertEquals("Charlie", customer.myNameTho())
    }
}