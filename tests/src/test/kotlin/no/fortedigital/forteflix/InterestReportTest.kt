package no.fortedigital.forteflix

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class InterestReportTest {
    private val serieDatabase = SerieDatabase()
    private val customerDatabase = CustomerDatabase(serieDatabase)
    private val interestReport = InterestReport(customerDatabase = customerDatabase, serieDatabase = serieDatabase)



    @BeforeEach
    fun setUp() {
        customerDatabase.clear()
        serieDatabase.clear()
    }

    @Test
    fun `generates interest report`() {
        val serie = Serie(title = "Min serie", types = setOf(SerieType.Drama, SerieType.Krim, SerieType.Animasjon))
        val customer = Customer(name = "Customer").apply {
            addSerieTypesOfInterest(SerieType.Drama, SerieType.Krim, SerieType.Reality)
        }
        serieDatabase.add(serie)
        customerDatabase.add(customer)

        val interestWeight = interestReport.findInterestWeight(customerId = customer.id, serieId = serie.id)
        assertEquals(2, interestWeight)
    }

    @Test
    fun `test findInterestWeight with invalid customer`() {
        // Create a serie
        val serie = Serie("Test Serie", setOf(SerieType.Krim, SerieType.Animasjon))

        // Add serie to the serie database
        serieDatabase.add(serie)

        // Call findInterestWeight with invalid customer and expect an exception
        assertThrows<IllegalArgumentException> {
            interestReport.findInterestWeight(-1, serie.id)
        }
    }

    @Test
    fun `test findInterestWeight with invalid serie`() {
        // Create a customer
        val customer = Customer("Hei")

        // Add customer to the customer database
        customerDatabase.add(customer)

        // Call findInterestWeight with invalid serie and expect an exception
        assertThrows<IllegalArgumentException> {
            interestReport.findInterestWeight(customer.id, -1)
        }
    }

    @Test
    fun `test highestSeries with no series`() {
        val highestSeries = interestReport.highestSeries()
        assertEquals(null, highestSeries)
    }

    @Test
    fun `test highestSeries`() {
        // Create series with different interest weights
        val serie1 = Serie("Serie 1", setOf(SerieType.Talkshow))
        val serie2 = Serie("Serie 2", setOf(SerieType.Talkshow, SerieType.Gameshow))
        val serie3 = Serie("Serie 3", setOf(SerieType.Talkshow, SerieType.Reality))

        // Add series to the serie database
        serieDatabase.add(serie1)
        serieDatabase.add(serie2)
        serieDatabase.add(serie3)

        // Set up interest weights for customers
        repeat(3) {
            customerDatabase.add(Customer("Customer").apply {
                addSerieTypesOfInterest(SerieType.Talkshow)
            })
        }

        // Call highestSeries and check the result
        val highestSeries = interestReport.highestSeries()
        assertEquals(serie1.title, highestSeries?.title)
    }
}