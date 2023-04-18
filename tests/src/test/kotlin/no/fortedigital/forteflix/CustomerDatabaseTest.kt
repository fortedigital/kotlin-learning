package no.fortedigital.forteflix

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import kotlin.test.assertEquals

internal class CustomerDatabaseTest {
    private val serieDatabase = SerieDatabase()
    private val customerDatabase = CustomerDatabase(serieDatabase)

    @BeforeEach
    fun setUp() {
        customerDatabase.clear()
        serieDatabase.clear()
    }

    @Test
    fun getById() {
        val customer = Customer(name = "OddMagne").apply {
            addSerieTypesOfInterest(SerieType.Talkshow, SerieType.Humor)
        }
        customerDatabase.add(customer)
        assertEquals(customer.name, customerDatabase.getById(customer.id)?.name)
    }

    @Test
    fun getBySerieId() {
        val customer = Customer(name = "OddMagne").apply {
            addSerieTypesOfInterest(SerieType.Talkshow, SerieType.Humor)
        }
        val serie = Serie(title = "Min serie", types = setOf(SerieType.Humor))
        val serie2 = Serie(title = "Min serie 2", types = setOf(SerieType.Animasjon))

        customerDatabase.add(customer)
        serieDatabase.add(serie)

        assertEquals(1, customerDatabase.getBySerieId(serie.id).size)
        assertEquals(0, customerDatabase.getBySerieId(serie2.id).size)
    }

    @Test
    fun getBetweenDates() {
        val january15 = Customer(name = "OddMagne", registrationDate = LocalDate.of(2022, Month.JANUARY, 15))
        val january30 = Customer(name = "Erik", registrationDate = LocalDate.of(2022, Month.JANUARY, 30))
        customerDatabase.add(january15)
        customerDatabase.add(january30)

        assertEquals(
            2,
            customerDatabase.getCustomersBetweenDates(
                start = LocalDate.of(2022, Month.JANUARY, 1),
                end = LocalDate.of(2022, Month.FEBRUARY, 15)
            ).size
        )

        assertEquals(
            2,
            customerDatabase.getCustomersBetweenDates(
                start = LocalDate.of(2022, Month.JANUARY, 15),
                end = LocalDate.of(2022, Month.FEBRUARY, 15)
            ).size
        )

        assertEquals(
            2,
            customerDatabase.getCustomersBetweenDates(
                start = LocalDate.of(2022, Month.JANUARY, 15),
                end = LocalDate.of(2022, Month.JANUARY, 30)
            ).size
        )

        assertEquals(
            1,
            customerDatabase.getCustomersBetweenDates(
                start = LocalDate.of(2022, Month.JANUARY, 16),
                end = LocalDate.of(2022, Month.FEBRUARY, 15)
            ).size
        )

        assertEquals(
            0,
            customerDatabase.getCustomersBetweenDates(
                start = LocalDate.of(2022, Month.MARCH, 16),
                end = LocalDate.of(2022, Month.MAY, 30)
            ).size
        )
    }
}